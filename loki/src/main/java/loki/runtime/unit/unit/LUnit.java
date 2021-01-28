package loki.runtime.unit.unit;

import loki.runtime.LUnitType;
import loki.runtime.context.LUnitContext;
import loki.runtime.error.LErrors;
import loki.runtime.marker.Compiler;
import loki.runtime.marker.Nullable;
import loki.runtime.marker.Polymorphic;
import loki.runtime.marker.compilerapi.unit.UnitAddParents;
import loki.runtime.marker.compilerapi.unit.UnitCall;
import loki.runtime.marker.compilerapi.unit.UnitCallMember;
import loki.runtime.marker.compilerapi.unit.UnitConstructor;
import loki.runtime.marker.compilerapi.unit.UnitGetCapturedUnitContext;
import loki.runtime.marker.compilerapi.unit.UnitGetIndexedItem;
import loki.runtime.marker.compilerapi.unit.UnitGetMember;
import loki.runtime.marker.compilerapi.unit.UnitGetSuperMember;
import loki.runtime.marker.compilerapi.unit.UnitSetIndexedItem;
import loki.runtime.marker.compilerapi.unit.UnitSetMember;
import loki.runtime.marker.compilerapi.unit.UnitSetParameterDefaultValue;
import loki.runtime.marker.compilerapi.unit.UnitSetParameterNames;
import loki.runtime.marker.compilerapi.unit.UnitSetType;
import loki.runtime.marker.compilerapi.unit.UnitToBoolean;
import loki.runtime.marker.compilerapi.unit.UnitToString;
import loki.runtime.unit.LModule;
import loki.runtime.unit.data.LString;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.member.method.LAddParents;
import loki.runtime.unit.unit.member.method.LGetIndexedItem;
import loki.runtime.unit.unit.member.method.LHashCode;
import loki.runtime.unit.unit.member.method.LNew;
import loki.runtime.unit.unit.member.method.LSetIndexedItem;
import loki.runtime.unit.unit.member.method.LToString;
import loki.runtime.unit.unit.member.operation.binary.LEquality;
import loki.runtime.unit.unit.member.operation.binary.LInequality;
import loki.runtime.unitdescriptor.LInstanceDescriptor;
import loki.runtime.unitdescriptor.LUnitDescriptor;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;

import static loki.runtime.LUnitType.SELF;
import static loki.runtime.error.LErrors.methodResultHasWrongType;
import static loki.runtime.error.LErrors.unitHasNoMember;
import static loki.runtime.error.LErrors.unitHasNoParameter;
import static loki.runtime.marker.Polymorphic.Type.ACCESS;
import static loki.runtime.marker.Polymorphic.Type.COMMON;
import static loki.runtime.marker.Polymorphic.Type.DEFAULT;

@SuppressWarnings("unchecked")
public abstract class LUnit
{
	public static final String PROTOTYPE_NAME = "UnitPrototype";

	public static final int MEMBERS_INITIAL_CAPACITY = 8;
	public static final float MEMBERS_LOAD_FACTOR = 0.75f;
	public static final int MEMBERS_CONCURRENCY_LEVEL = 1;

	@Compiler
	public static final LUnit[] EMPTY_UNIT_ARRAY = {};

	private static volatile LUnit prototype;

	private LUnitType type;
	private volatile @Nullable LUnitContext capturedUnitContext;
	private volatile @Nullable ConcurrentLinkedDeque<LUnit> parents;
	private volatile @Nullable ConcurrentMap<String, LUnit> members;
	private volatile @Nullable Map<String, Integer> parameterIndexes;
	private volatile @Nullable LUnit[] parameterDefaultValues;

	public LUnit()
	{
		this(null, null);
	}

	public LUnit(LUnitDescriptor<?> unitDescriptor)
	{
		this(unitDescriptor.getUnitType());
	}

	public LUnit(@Nullable LUnitType type)
	{
		this(type, null);
	}

	@UnitConstructor
	public LUnit(@Nullable LUnitContext capturedUnitContext)
	{
		this(null, capturedUnitContext);
	}

	public LUnit(@Nullable LUnitType type, @Nullable LUnitContext capturedUnitContext)
	{
		this.type = type;
		this.capturedUnitContext = capturedUnitContext;
	}

	@Polymorphic(COMMON)
	public LUnit newInstance(LUnit[] parameters)
	{
		return
			new LUnit(getCapturedUnitContext())
			{
				{
					setType(LUnit.this.getType());
					addParents(LUnit.this);
					call(this, parameters);
				}

				@Override
				public LUnit call(LUnit host, LUnit... parameters)
				{
					return LUnit.this.call(host, parameters);
				}
			};
	}

	public static LUnit getPrototype()
	{
		return initPrototype();
	}

	public boolean isModule()
	{
		return this instanceof LModule;
	}

	public boolean hasCapturedUnitContext()
	{
		return getCapturedUnitContext() != null;
	}

	public LUnitType getType()
	{
		return type;
	}

	@UnitSetType
	public void setType(LUnitType type)
	{
		this.type = type;
	}

	public Optional<LUnitContext> getOptionalCapturedUnitContext()
	{
		return Optional.ofNullable(capturedUnitContext);
	}

	@UnitGetCapturedUnitContext
	public @Nullable LUnitContext getCapturedUnitContext()
	{
		return capturedUnitContext;
	}

	public Map<String, Integer> getParameterIndexes()
	{
		return parameterIndexes != null ? parameterIndexes : Collections.emptyMap();
	}

	public LUnit[] getParameterDefaultValues()
	{
		return parameterDefaultValues != null ? parameterDefaultValues : EMPTY_UNIT_ARRAY;
	}

	public void addMember(LInstanceDescriptor<?> memberDescriptor)
	{
		setMember(memberDescriptor.getUnitName(), memberDescriptor.getInstance());
	}

	public LUnit getMember(String memberName, BiConsumer<LUnit, String> callbackOnFail)
	{
		LUnit member = getMember(memberName);

		if (LVoid.isTypeOf(member)) callbackOnFail.accept(this, memberName);

		return member;
	}

	@UnitGetMember
	public LUnit getMember(String memberName)
	{
		return
			Optional
				.ofNullable(members)
				.flatMap(members -> Optional.ofNullable(members.get(memberName)))
				.orElseGet(() -> getSuperMember(memberName));
	}

	@UnitSetMember
	public LUnit setMember(String memberName, LUnit member)
	{
		initMembers().put(memberName, member);

		return member;
	}

	@UnitGetSuperMember
	public LUnit getSuperMember(String superMemberName)
	{
		for (Iterator<LUnit> parentIterator = initParents().descendingIterator(); parentIterator.hasNext();)
		{
			LUnit member = parentIterator.next().getMember(superMemberName);

			if (!LVoid.isTypeOf(member)) return member;
		}

		return LVoid.getInstance();
	}

	@Polymorphic(ACCESS)
	@UnitAddParents
	public LUnit addParents(LUnit... parents)
	{
		callMember(LAddParents.DESCRIPTOR, parents);

		return this;
	}

	@Polymorphic(DEFAULT)
	public LUnit _addParents(LUnit... parents)
	{
		initParents().addAll(Arrays.asList(parents));

		return this;
	}

	@UnitCall
	public LUnit call(@Compiler LUnit host, @Compiler LUnit... parameters)
	{
		return LVoid.getInstance();
	}

	public LUnit callMember(LInstanceDescriptor<?> memberDescriptor, LUnit... parameters)
	{
		return callMember(memberDescriptor.getUnitType().getName(), parameters);
	}

	@UnitCallMember
	public LUnit callMember(String memberName, LUnit... parameters)
	{
		return getMember(memberName, LErrors::unitHasNoMember).call(this, parameters);
	}

	@Polymorphic(ACCESS)
	@UnitGetIndexedItem
	public LUnit getIndexedItem(LUnit index)
	{
		return callMember(LGetIndexedItem.DESCRIPTOR, index);
	}

	@Polymorphic(DEFAULT)
	public LUnit _getIndexedItem(LUnit[] parameters)
	{
		return LVoid.getInstance();
	}

	@Polymorphic(ACCESS)
	@UnitSetIndexedItem
	public LUnit setIndexedItem(LUnit index, LUnit value)
	{
		callMember(LSetIndexedItem.DESCRIPTOR, index);

		return value;
	}

	@Polymorphic(DEFAULT)
	public LUnit _setIndexedItem(LUnit[] parameters)
	{
		return LVoid.getInstance();
	}

	@UnitSetParameterNames
	public LUnit setParameterNames(String[] parameterNames)
	{
		Map.Entry<String, Integer>[] entries = new Map.Entry[parameterNames.length];

		for (int i = 0; i < parameterNames.length; i++)
			entries[i] = new AbstractMap.SimpleImmutableEntry<>(parameterNames[i], i);

		this.parameterIndexes = Map.ofEntries(entries);

		return this;
	}

	@UnitSetParameterDefaultValue
	public void setParameterDefaultValue(int parameterIndex, LUnit parameterDefaultValue)
	{
		if (parameterDefaultValues == null) parameterDefaultValues = new LUnit[parameterIndexes.size()];

		parameterDefaultValues[parameterIndex] = parameterDefaultValue;
	}

	@Override
	@Polymorphic(DEFAULT)
	public int hashCode()
	{
		return (int)
			callMember(LHashCode.DESCRIPTOR)
				.asType(LNumber.DESCRIPTOR, methodResultHasWrongType(this, LHashCode.DESCRIPTOR))
				.getValue();
	}

	@Polymorphic(DEFAULT)
	public LNumber _hashCode()
	{
		return new LNumber(super.hashCode());
	}

	@Override
	@Polymorphic(ACCESS)
	public boolean equals(@Nullable Object object)
	{
		if (!(object instanceof LUnit)) return false;

		return
			callMember(LEquality.DESCRIPTOR, (LUnit)object)
				.asType(LBoolean.DESCRIPTOR, methodResultHasWrongType(this, LEquality.DESCRIPTOR))
				.getValue();
	}

	@Polymorphic(DEFAULT)
	public LBoolean _equals(LUnit otherUnit)
	{
		return LBoolean.valueOf(super.equals(otherUnit));
	}

	@Override
	@Polymorphic(ACCESS)
	@UnitToString
	public String toString()
	{
		return
			callMember(LToString.DESCRIPTOR)
				.asType(LString.DESCRIPTOR, methodResultHasWrongType(this, LToString.DESCRIPTOR))
				.getValue();
	}

	@Polymorphic(DEFAULT)
	public LString _toString()
	{
		return new LString(getType().getFullName());
	}

	@UnitToBoolean
	public boolean toBoolean()
	{
		return asType(LBoolean.DESCRIPTOR, LErrors::unitHasWrongType).getValue();
	}

	public boolean isType(@Nullable LUnitDescriptor<?> unitDescriptor)
	{
		return isType(unitDescriptor.getUnitType());
	}

	public boolean isType(@Nullable LUnitType type)
	{
		return asType(type) != null;
	}

	public @Nullable <TYPE extends LUnit> TYPE asType(
		LUnitDescriptor<TYPE> unitDescriptor, BiConsumer<LUnit, LUnitDescriptor<TYPE>> callbackOnFail
	)
	{
		TYPE type = asType(unitDescriptor.getUnitType());

		if (type == null) callbackOnFail.accept(this, unitDescriptor);

		return type;
	}

	public @Nullable <TYPE extends LUnit> TYPE asType(LUnitDescriptor<TYPE> unitDescriptor)
	{
		return asType(unitDescriptor.getUnitType());
	}

	public @Nullable <TYPE extends LUnit> TYPE asType(LUnitType type)
	{
		if (type == SELF) return (TYPE)this;

		if (getType() == type) return (TYPE)this;

		for (Iterator<LUnit> parentIterator = initParents().descendingIterator(); parentIterator.hasNext();)
		{
			LUnit parentAsType = parentIterator.next().asType(type);

			if (parentAsType != null) return (TYPE)parentAsType;
		}

		return null;
	}

	protected LUnit getParameter(LUnit[] parameters, int parameterIndex)
	{
		if (parameterIndex < 0 || parameterIndex >= parameters.length) unitHasNoParameter(this, parameterIndex);

		return parameters[parameterIndex];
	}

	protected ConcurrentLinkedDeque<LUnit> initParents()
	{
		if (parents == null) synchronized(this)
		{
			if (parents == null)
			{
				parents = new ConcurrentLinkedDeque<>();

				_addParents(initPrototype());
			}
		}

		return parents;
	}

	private ConcurrentMap<String, LUnit> initMembers()
	{
		if (members == null) synchronized(this)
		{
			if (members == null)
				members =
					new ConcurrentHashMap<>(MEMBERS_INITIAL_CAPACITY, MEMBERS_LOAD_FACTOR, MEMBERS_CONCURRENCY_LEVEL);
		}

		return members;
	}

	private static LUnit initPrototype()
	{
		if (prototype == null) synchronized(LUnit.class)
		{
			if (prototype == null)
				prototype =
					new LUnit()
					{
						{
							setType(new LUnitType(PROTOTYPE_NAME, getClass()));

							initializeBuiltins();
						}

						@Override
						public LUnit getSuperMember(String superMemberName)
						{
							return LVoid.getInstance();
						}

						@Override
						public LUnit addParents(LUnit... parents)
						{
							return unitHasNoMember(this, LAddParents.DESCRIPTOR);
						}

						@Override
						public LUnit _addParents(LUnit... parents)
						{
							return unitHasNoMember(this, LAddParents.DESCRIPTOR);
						}

						@Override
						public <TYPE extends LUnit> TYPE asType(LUnitType type)
						{
							if (getType() == type) return (TYPE)this;

							return null;
						}

						@Override
						protected ConcurrentLinkedDeque<LUnit> initParents()
						{
							return null;
						}

						private void initializeBuiltins()
						{
							addMember(LNew.DESCRIPTOR);
							addMember(LAddParents.DESCRIPTOR);
							addMember(LGetIndexedItem.DESCRIPTOR);
							addMember(LSetIndexedItem.DESCRIPTOR);
							addMember(LToString.DESCRIPTOR);
							addMember(LHashCode.DESCRIPTOR);
							addMember(LEquality.DESCRIPTOR);
							addMember(LInequality.DESCRIPTOR);
						}
					};
		}

		return prototype;
	}
}