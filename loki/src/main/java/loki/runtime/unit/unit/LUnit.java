package loki.runtime.unit.unit;

import loki.runtime.LSettings;
import loki.runtime.LType;
import loki.runtime.compilerapi.unit.*;
import loki.runtime.context.LUnitContext;
import loki.runtime.error.LErrors;
import loki.runtime.unit.data.LString;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.member.*;
import loki.runtime.unit.unit.member.operation.binary.LEqualityUnitBinaryOperation;
import loki.runtime.unit.unit.member.operation.binary.LInequalityUnitBinaryOperation;
import loki.runtime.unitdescriptor.LTypeUnitDescriptor;
import loki.runtime.util.Compiler;
import loki.runtime.util.Nullable;
import loki.runtime.util.Polymorphic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;

import static loki.runtime.util.Polymorphic.Type.*;

@SuppressWarnings("unchecked")
public abstract class LUnit
{
	public static final String PROTOTYPE_NAME = "UnitPrototype";

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
		LUnit newUnit = new LUnit(getCapturedUnitContext())
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
		initPrototypeIfNecessary();

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

	public void addMember(LUnit unitMember)
	{
		setMember(unitMember.getType().getName(), unitMember);
	}

	@UnitGetMember
	public LUnit getMember(String memberName)
	{
		if (members != null)
		{
			LUnit member = members.get(memberName);

			if (member != null) return member;
		}

		return getSuperMember(memberName);
	}

	@UnitSetMember
	public LUnit setMember(String memberName, LUnit member)
	{
		initMembersIfNecessary().put(memberName, member);

		return member;
	}

	@UnitGetSuperMember
	public LUnit getSuperMember(String superMemberName)
	{
		for (Iterator<LUnit> parentIterator = initParentsIfNecessary().descendingIterator(); parentIterator.hasNext();)
		{
			LUnit parent = parentIterator.next();
			LUnit member = parent.getMember(superMemberName);

			if (member != LVoid.DESCRIPTOR.getInstance()) return member;
		}

		return LVoid.DESCRIPTOR.getInstance();
	}

	@Polymorphic(ACCESS)
	@UnitAddParents
	public LUnit addParents(LUnit... parents)
	{
		callMember(LAddParents.DESCRIPTOR.getType().getName(), parents);

		return this;
	}

	@Polymorphic(DEFAULT)
	public LUnit _addParents(LUnit... parents)
	{
		initParentsIfNecessary().addAll(Arrays.asList(parents));

		return this;
	}

	@UnitCall
	public LUnit call(@Compiler LUnit host, @Compiler LUnit... parameters)
	{
		return LVoid.DESCRIPTOR.getInstance();
	}

	@UnitCallMember
	public LUnit callMember(String memberName, LUnit[] parameters)
	{
		return getMember(memberName).call(this, parameters);
	}

	@Polymorphic(ACCESS)
	@UnitGetIndexedItem
	public LUnit getIndexedItem(LUnit index)
	{
		return callMember(LGetIndexedItem.DESCRIPTOR.getType().getName(), new LUnit[] {index});
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
		callMember(LSetIndexedItem.DESCRIPTOR.getType().getName(), new LUnit[] {index});

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
		HashMap<String, Integer> parameterIndexes =
			new HashMap<>(LSettings.UNIT_PARAMETER_NAMES_INITIAL_CAPACITY, LSettings.UNIT_PARAMETER_NAMES_LOAD_FACTOR);

		for (int i = 0; i < parameterNames.length; i++) parameterIndexes.put(parameterNames[i], i);

		this.parameterIndexes = parameterIndexes;

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
		LNumber hashCode =
			callMember(LHashCode.DESCRIPTOR.getType().getName(), EMPTY_UNIT_ARRAY).asType(LNumber.DESCRIPTOR.getType());

		if (hashCode == null)
			LErrors
				.unitOperationResultShouldHaveType(
					LHashCode.DESCRIPTOR.getType(), this, LNumber.DESCRIPTOR.getType()
				);

		return (int)hashCode.getValue();
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

		return callMember(LEquals.DESCRIPTOR.getType().getName(), new LUnit[] {(LUnit)object}).toBoolean();
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
		LString string =
			callMember(LToString.DESCRIPTOR.getType().getName(), EMPTY_UNIT_ARRAY).asType(LString.DESCRIPTOR.getType());

		if (string == null)
			LErrors
				.unitOperationResultShouldHaveType(
					LToString.DESCRIPTOR.getType(), this, LString.DESCRIPTOR.getType()
				);

		return string.getValue();
	}

	@Polymorphic(DEFAULT)
	public LString _toString()
	{
		return new LString(getType().toString());
	}

	@UnitToBoolean
	public boolean toBoolean()
	{
		LBoolean bool = asType(LBoolean.DESCRIPTOR.getType());

		if (bool == null) LErrors.operandShouldHaveType(this, LNumber.DESCRIPTOR.getType());

		return bool.getValue();
	}

	public boolean isType(@Nullable LType type)
	{
		return asType(type) != null;
	}

	public @Nullable <TYPE extends LUnit> TYPE asType(
		LTypeUnitDescriptor<TYPE> typeDescriptor, BiConsumer<LUnit, LTypeUnitDescriptor<TYPE>> callbackOnFail
	)
	{
		TYPE type = asType(typeDescriptor.getType());

		if (type == null) callbackOnFail.accept(this, typeDescriptor);

		return type;
	}

	public @Nullable <TYPE extends LUnit> TYPE asType(@Nullable LType type)
	{
		if (type == null) return (TYPE)this;

		if (getType() == type) return (TYPE)this;

		for (Iterator<LUnit> parentIterator = initParentsIfNecessary().descendingIterator(); parentIterator.hasNext();)
		{
			LUnit parentAsType = parentIterator.next().asType(type);

			if (parentAsType != null) return (TYPE)parentAsType;
		}

		return null;
	}

	protected LUnit checkCallParameter(LUnit[] parameters, int parameterIndex)
	{
		if (parameterIndex < 0 || parameterIndex >= parameters.length)
			LErrors.parameterIsMissedForUnit(parameterIndex, this);

		return parameters[parameterIndex];
	}

	private ConcurrentMap<String, LUnit> initMembersIfNecessary()
	{
		if (members == null) synchronized(this)
		{
			if (members == null)
				members =
					new ConcurrentHashMap<>(
						LSettings.UNIT_MEMBERS_INITIAL_CAPACITY,
						LSettings.UNIT_MEMBERS_LOAD_FACTOR,
						LSettings.UNIT_MEMBERS_CONCURRENCY_LEVEL
					);
		}

		return members;
	}

	protected ConcurrentLinkedDeque<LUnit> initParentsIfNecessary()
	{
		if (parents == null) synchronized(this)
		{
			if (parents == null)
			{
				parents = new ConcurrentLinkedDeque<>();
				initPrototypeIfNecessary();
				_addParents(prototype);
			}
		}

		return parents;
	}

	private static void initPrototypeIfNecessary()
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
							return LVoid.DESCRIPTOR.getInstance();
						}

						@Override
						public LUnit addParents(LUnit... parents)
						{
							LErrors.actionIsNotAllowedForUnit("adding parents", this);

							return LVoid.DESCRIPTOR.getInstance();
						}

						@Override
						public LUnit _addParents(LUnit... parents)
						{
							LErrors.actionIsNotAllowedForUnit("adding parents", this);

							return LVoid.DESCRIPTOR.getInstance();
						}

						@Override
						public @Nullable <TYPE extends LUnit> TYPE asType(@Nullable LType type)
						{
							if (getType().equals(type)) return (TYPE)this;

							return null;
						}

						@Override
						protected @Nullable ConcurrentLinkedDeque<LUnit> initParentsIfNecessary()
						{
							return null;
						}

						private void initializeBuiltins()
						{
							addMember(LNew.DESCRIPTOR.getInstance());
							addMember(LAddParents.DESCRIPTOR.getInstance());
							addMember(LGetIndexedItem.DESCRIPTOR.getInstance());
							addMember(LSetIndexedItem.DESCRIPTOR.getInstance());
							addMember(LToString.DESCRIPTOR.getInstance());
							addMember(LHashCode.DESCRIPTOR.getInstance());
							addMember(LEquals.DESCRIPTOR.getInstance());
							addMember(LEqualityUnitBinaryOperation.DESCRIPTOR.getInstance());
							addMember(LInequalityUnitBinaryOperation.DESCRIPTOR.getInstance());
						}
					};
		}
	}
}