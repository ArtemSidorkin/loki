package loki.runtime.unit.unit;

import loki.runtime.LSettings;
import loki.runtime.context.LUnitContext;
import loki.runtime.unit.LString;
import loki.runtime.unit.LVoid;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.LNumber;
import loki.runtime.LType;
import loki.runtime.unit.unit.member.*;
import loki.runtime.unit.unit.member.operation.binary.LEqualityUnitBinaryOperation;
import loki.runtime.unit.unit.member.operation.binary.LInequalityUnitBinaryOperation;
import loki.runtime.util.Compiler;
import loki.runtime.util.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;

import static loki.runtime.util.Polymorphic.Type.*;

public abstract class LUnit
{
	public static final String PROTOTYPE_NAME = "UnitPrototype";

	public static final LUnit[] EMPTY_UNIT_ARRAY = {};

	private static volatile LUnit prototype;

	private LType type;
	private volatile @Nullable LUnitContext capturedUnitContext;
	private volatile @Nullable ConcurrentLinkedDeque<LUnit> parents;
	private volatile @Nullable ConcurrentMap<String, LUnit> members;
	private volatile @Nullable Map<String, Integer> parameterIndexes;

	public LUnit()
	{
		this(null, null);
	}


	public LUnit(@Nullable LType type)
	{
		this(type, null);
	}

	public LUnit(@Nullable LUnitContext capturedUnitContext)
	{
		this(null, capturedUnitContext);
	}

	public LUnit(@Nullable LType type, @Nullable LUnitContext capturedUnitContext)
	{
		this.type = type;
		this.capturedUnitContext = capturedUnitContext;
	}

	@Internal
	@Polymorphic(COMMON)
	public LUnit newInstance(LUnit[] parameters, @Nullable Consumer<LUnit> saver)
	{
		LUnit newUnit = new LUnit(getCapturedUnitContext())
		{
			{
				setType(LUnit.this.getType());
			}

			@Override
			public LUnit call(LUnit host, LUnit[] parameters)
			{
				return LUnit.this.call(host, parameters);
			}
		};

		if (saver != null) saver.accept(newUnit);

		newUnit.addParents(this);

		call(newUnit, parameters);

		return newUnit;
	}

	@Internal
	public static LUnit getPrototype()
	{
		initPrototypeIfNecessary();

		return prototype;
	}

	@Internal
	public LType getType()
	{
		return type;
	}

	public void setType(LType type)
	{
		this.type = type;
	}

	@Compiler
	public @Nullable LUnitContext getCapturedUnitContext()
	{
		return capturedUnitContext;
	}

	@Internal
	public @Nullable Map<String, Integer> getParameterIndexes()
	{
		return parameterIndexes;
	}

	@Compiler
	public LUnit getMember(String memberName)
	{
		if (members != null)
		{
			LUnit member = members.get(memberName);

			if (member != null) return member;
		}

		return getSuperMember(memberName);
	}

	@Compiler
	public LUnit setMember(String memberName, LUnit member)
	{
		initMembersIfNecessary().put(memberName, member);

		return member;
	}

	@Compiler
	public LUnit getSuperMember(String superMemberName)
	{
		for (Iterator<LUnit> parentIterator = initParentsIfNecessary().descendingIterator(); parentIterator.hasNext();)
		{
			LUnit parent = parentIterator.next();
			LUnit member = parent.getMember(superMemberName);

			if (member != LVoid.INSTANCE) return member;
		}

		return LVoid.INSTANCE;
	}

	@Compiler
	@Polymorphic(ACCESS)
	public LUnit addParents(LUnit... parents)
	{
		callMember(LAddParents.TYPE_NAME, parents);

		return this;
	}

	@Internal
	@Polymorphic(DEFAULT)
	public LUnit _addParents(LUnit... parents)
	{
		initParentsIfNecessary().addAll(Arrays.asList(parents));

		return this;
	}

	@Compiler
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return LVoid.INSTANCE;
	}

	@Compiler
	public LUnit callMember(String memberName, LUnit[] parameters)
	{
		return getMember(memberName).call(this, parameters);
	}

	@Internal
	@Polymorphic(ACCESS)
	public LUnit getIndexedItem(LUnit index)
	{
		return callMember(LGetIndexedItem.TYPE_NAME, new LUnit[] {index});
	}

	@Internal
	@Polymorphic(DEFAULT)
	public LUnit _getIndexedItem(LUnit[] parameters)
	{
		return LVoid.INSTANCE;
	}

	@Internal
	@Polymorphic(ACCESS)
	public LUnit setIndexedItem(LUnit index, LUnit value)
	{
		callMember(LSetIndexedItem.TYPE_NAME, new LUnit[] {index});

		return value;
	}

	@Internal
	@Polymorphic(DEFAULT)
	public LUnit _setIndexedItem(LUnit[] parameters)
	{
		return LVoid.INSTANCE;
	}

	@Compiler
	public LUnit setParameterNames(String[] parameterNames)
	{
		HashMap<String, Integer> parameterIndexes =
			new HashMap<>(LSettings.UNIT_PARAMETER_NAMES_INITIAL_CAPACITY, LSettings.UNIT_PARAMETER_NAMES_LOAD_FACTOR);

		for (int i = 0; i < parameterNames.length; i++) parameterIndexes.put(parameterNames[i], i);

		this.parameterIndexes = parameterIndexes;

		return this;
	}

	@Internal
	@Polymorphic(DEFAULT)
	@Override
	public int hashCode()
	{
		LNumber hashCode = callMember(LHashCode.TYPE_NAME, EMPTY_UNIT_ARRAY).asType(LNumber.TYPE);

		if (hashCode == null)
			LErrors
				.resultOfOperationOfUnitShouldHaveType(LHashCode.TYPE, this, LNumber.TYPE);

		return (int)hashCode.getValue();
	}

	@Internal
	@Polymorphic(DEFAULT)
	public LNumber _hashCode()
	{
		return new LNumber(super.hashCode());
	}

	@Internal
	@Polymorphic(ACCESS)
	@Override
	public boolean equals(@Nullable Object object)
	{
		if (!(object instanceof LUnit)) return false;

		return callMember(LEquals.TYPE_NAME, new LUnit[] {(LUnit)object}).toBoolean();
	}

	@Internal
	@Polymorphic(DEFAULT)
	public LBoolean _equals(LUnit unit)
	{
		return LBoolean.valueOf(super.equals(unit));
	}

	@Compiler
	@Polymorphic(ACCESS)
	@Override
	public String toString()
	{
		LString string = callMember(LToString.TYPE_NAME, EMPTY_UNIT_ARRAY).asType(LString.TYPE);

		if (string == null)
			LErrors
				.resultOfOperationOfUnitShouldHaveType(LToString.TYPE, this, LString.TYPE);

		return string.getValue();
	}

	@Internal
	@Polymorphic(DEFAULT)
	public LString _toString()
	{
		return new LString(getType().toString());
	}

	@Compiler
	@Invariable
	public boolean toBoolean()
	{
		LBoolean bool = asType(LBoolean.TYPE);

		if (bool == null) LErrors.operandShouldHaveType(this, LNumber.TYPE);

		return bool.getValue();
	}

	@Internal
	public boolean isType(@Nullable LType type)
	{
		return asType(type) != null;
	}

	@Internal
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

	@Internal
	protected LUnit checkCallParameter(LUnit[] parameters, int parameterIndex)
	{
		if (parameterIndex < 0 || parameterIndex >= parameters.length)
			LErrors.parameterIsMissedForUnit(parameterIndex, this);

		return parameters[parameterIndex];
	}

	@Internal
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

	@Internal
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

	@Internal
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
							return LVoid.INSTANCE;
						}

						@Override
						public LUnit addParents(LUnit... parents)
						{
							LErrors.printErrorAndExit("Adding parent to UnitPrototype is not allowed");

							return LVoid.INSTANCE;
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
							LNew.INSTANCE.init(this);
							LAddParents.INSTANCE.init(this);
							LGetIndexedItem.instance.init(this);
							LSetIndexedItem.INSTANCE.init(this);
							LToString.INSTANCE.init(this);
							LHashCode.INSTANCE.init(this);
							LEquals.INSTANCE.init(this);
							LEqualityUnitBinaryOperation.INSTANCE.init(this);
							LInequalityUnitBinaryOperation.INSTANCE.init(this);
						}
					};
		}
	}
}