package loki.runtime.unit.unit;

import loki.runtime.LType;
import loki.runtime.compilerapi.unit.UnitAddParents;
import loki.runtime.compilerapi.unit.UnitCall;
import loki.runtime.compilerapi.unit.UnitCallMember;
import loki.runtime.compilerapi.unit.UnitConstructor;
import loki.runtime.compilerapi.unit.UnitGetCapturedUnitContext;
import loki.runtime.compilerapi.unit.UnitGetIndexedItem;
import loki.runtime.compilerapi.unit.UnitGetMember;
import loki.runtime.compilerapi.unit.UnitGetSuperMember;
import loki.runtime.compilerapi.unit.UnitSetIndexedItem;
import loki.runtime.compilerapi.unit.UnitSetMember;
import loki.runtime.compilerapi.unit.UnitSetParameterDefaultValue;
import loki.runtime.compilerapi.unit.UnitSetParameterNames;
import loki.runtime.compilerapi.unit.UnitSetType;
import loki.runtime.compilerapi.unit.UnitToBoolean;
import loki.runtime.compilerapi.unit.UnitToString;
import loki.runtime.context.LUnitContext;
import loki.runtime.error.LErrors;
import loki.runtime.unit.data.LString;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.member.LAddParents;
import loki.runtime.unit.unit.member.LEquals;
import loki.runtime.unit.unit.member.LGetIndexedItem;
import loki.runtime.unit.unit.member.LHashCode;
import loki.runtime.unit.unit.member.LNew;
import loki.runtime.unit.unit.member.LSetIndexedItem;
import loki.runtime.unit.unit.member.LToString;
import loki.runtime.unit.unit.member.operation.binary.LEqualityUnitBinaryOperation;
import loki.runtime.unit.unit.member.operation.binary.LInequalityUnitBinaryOperation;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;
import loki.runtime.unitdescriptor.LUnitDescriptor;
import loki.runtime.util.Compiler;
import loki.runtime.util.Nullable;
import loki.runtime.util.Polymorphic;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;

import static loki.runtime.error.LErrors.methodResultHasWrongType;
import static loki.runtime.error.LErrors.unitHasNoParameter;
import static loki.runtime.error.LErrors.unitHasNoMember;
import static loki.runtime.util.Polymorphic.Type.ACCESS;
import static loki.runtime.util.Polymorphic.Type.COMMON;
import static loki.runtime.util.Polymorphic.Type.DEFAULT;

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

	private LType type;
	private volatile @Nullable LUnitContext capturedUnitContext;
	private volatile @Nullable ConcurrentLinkedDeque<LUnit> parents;
	private volatile @Nullable ConcurrentMap<String, LUnit> members;
	private volatile @Nullable Map<String, Integer> parameterIndexes;
	private volatile @Nullable LUnit[] parameterDefaultValues;

	public LUnit()
	{
		this(null, null);
	}

	public LUnit(@Nullable LType type)
	{
		this(type, null);
	}

	@UnitConstructor
	public LUnit(@Nullable LUnitContext capturedUnitContext)
	{
		this(null, capturedUnitContext);
	}

	public LUnit(@Nullable LType type, @Nullable LUnitContext capturedUnitContext)
	{
		this.type = type;
		this.capturedUnitContext = capturedUnitContext;
	}

	@Polymorphic(COMMON)
	public LUnit newInstance(LUnit[] parameters)
	{
		LUnit newUnit =
			new LUnit(getCapturedUnitContext())
			{
				{
					setType(LUnit.this.getType());
				}

				@Override
				public LUnit call(LUnit host, LUnit... parameters)
				{
					return LUnit.this.call(host, parameters);
				}
			};

		newUnit.addParents(this);

		call(newUnit, parameters);

		return newUnit;
	}

	public static LUnit getPrototype()
	{
		initPrototype();

		return prototype;
	}

	public LType getType()
	{
		return type;
	}

	@UnitSetType
	public void setType(LType type)
	{
		this.type = type;
	}

	@UnitGetCapturedUnitContext
	public @Nullable LUnitContext getCapturedUnitContext()
	{
		return capturedUnitContext;
	}

	public @Nullable Map<String, Integer> getParameterIndexes()
	{
		return parameterIndexes;
	}

	public @Nullable LUnit[] getParameterDefaultValues()
	{
		return parameterDefaultValues;
	}

	public void addMember(LInstanceUnitDescriptor<?> memberDescriptor)
	{
		setMember(memberDescriptor.getName(), memberDescriptor.getInstance());
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

			if (!LVoid.hasInstance(member)) return member;
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

	public LUnit callMember(LUnitDescriptor<?> memberDescriptor, LUnit... parameters)
	{
		return callMember(memberDescriptor.getType().getName(), parameters);
	}

	@UnitCallMember
	public LUnit callMember(String memberName, LUnit... parameters)
	{
		LUnit member = getMember(memberName);

		if (LVoid.hasInstance(member)) unitHasNoMember(this, memberName);

		return member.call(this, parameters);
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
		return LVoid.DESCRIPTOR.getInstance();
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
		return LVoid.DESCRIPTOR.getInstance();
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
			callMember(LEquals.DESCRIPTOR, (LUnit)object)
				.asType(LBoolean.DESCRIPTOR, methodResultHasWrongType(this, LEquals.DESCRIPTOR))
				.getValue();
	}

	@Polymorphic(DEFAULT)
	public LBoolean _equals(LUnit unit)
	{
		return LBoolean.valueOf(super.equals(unit));
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

	public boolean isType(@Nullable LType type)
	{
		return asType(type) != null;
	}

	public @Nullable <TYPE extends LUnit> TYPE asType(
		@Nullable LUnitDescriptor<TYPE> typeDescriptor, BiConsumer<LUnit, LUnitDescriptor<TYPE>> callbackOnFail
	)
	{
		TYPE type = asType(typeDescriptor != null ? typeDescriptor.getType() : null);

		if (type == null) callbackOnFail.accept(this, typeDescriptor);

		return type;
	}

	public @Nullable <TYPE extends LUnit> TYPE asType(@Nullable LType type)
	{
		if (type == null) return (TYPE)this;

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

	protected ConcurrentLinkedDeque<LUnit> initParents()
	{
		if (parents == null) synchronized(this)
		{
			if (parents == null)
			{
				parents = new ConcurrentLinkedDeque<>();
				initPrototype();
				_addParents(prototype);
			}
		}

		return parents;
	}

	private static void initPrototype()
	{
		if (prototype == null) synchronized(LUnit.class)
		{
			if (prototype == null)
				prototype =
					new LUnit()
					{
						{
							setType(new LType(PROTOTYPE_NAME, getClass()));

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
							unitHasNoMember(this, LAddParents.DESCRIPTOR);

							return LVoid.getInstance();
						}

						@Override
						public LUnit _addParents(LUnit... parents)
						{
							unitHasNoMember(this, LAddParents.DESCRIPTOR);

							return LVoid.getInstance();
						}

						@Override
						public @Nullable <TYPE extends LUnit> TYPE asType(@Nullable LType type)
						{
							if (getType().equals(type)) return (TYPE)this;

							return null;
						}

						@Override
						protected @Nullable ConcurrentLinkedDeque<LUnit> initParents()
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
							addMember(LEquals.DESCRIPTOR);
							addMember(LEqualityUnitBinaryOperation.DESCRIPTOR);
							addMember(LInequalityUnitBinaryOperation.DESCRIPTOR);
						}
					};
		}
	}
}