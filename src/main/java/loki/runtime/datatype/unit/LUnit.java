package loki.runtime.datatype.unit;

import loki.runtime.LSettings;
import loki.runtime.builtin.operation.binary.unit.LUnitBangEquals;
import loki.runtime.builtin.operation.binary.unit.LUnitEqualsEquals;
import loki.runtime.constant.LDataUnit;
import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.*;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.type.LType;
import loki.runtime.datatype.unit.member.*;
import loki.runtime.util.Internal;
import loki.runtime.util.LErrors;
import loki.runtime.util.Nullable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;

public abstract class LUnit
{
	public static final LUnit[] EMPTY_UNIT_ARRAY = {};

	private static volatile LUnit prototype;

	@Nullable protected volatile LUnitContext capturedOnCreationUnitContext;

	private final LType type;
	protected volatile ConcurrentLinkedDeque<LUnit> parents;
	@Nullable protected volatile ConcurrentMap<String, LUnit> members;
	@Nullable private volatile Map<String, Integer> parameterIndexes;

	public LUnit()
	{
		type = null;
	}

	public LUnit(LType type)
	{
		this(type, null);
	}

	public LUnit(LType type, @Nullable LUnitContext capturedOnCreationUnitContext)
	{
		this.type = type;
		this.capturedOnCreationUnitContext = capturedOnCreationUnitContext;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*Compiler API                                                                                                    */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public LUnit getMember(String memberName)
	{
		if (members != null)
		{
			LUnit member = members.get(memberName);

			if (member != null) return member;
		}

		return getSuperMember(memberName);
	}

	public LUnit setMember(String memberName, LUnit member)
	{
		initMembersIfNecessary().put(memberName, member);

		return member;
	}

	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return LUndefined.instance;
	}

	public LUnit callMember(String memberName, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return getMember(memberName).call(this, parameters, unitContext);
	}

	public LUnit setParameterNames(@Nullable String[] parameterNames)
	{
		HashMap<String, Integer> parameterIndexes = new HashMap<>(
			LSettings.UNIT_PARAMETER_NAMES_INITIAL_CAPACITY, LSettings.UNIT_PARAMETER_NAMES_LOAD_FACTOR
		);

		for (int i = 0; i < parameterNames.length; i++) parameterIndexes.put(parameterNames[i], i);

		this.parameterIndexes = parameterIndexes;

		return this;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*Polymorphic Methods on Internal Level                                                                           */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public LUnit _getIndexedItem(@Nullable LUnit[] parameters)
	{
		return LUndefined.instance;
	}

	public LUnit _setIndexedItem(@Nullable LUnit[] parameters)
	{
		return LUndefined.instance;
	}

	@Override
	public int hashCode()
	{
		LUnit hashCodeAsUnit = callMember(LUnitMember.HASH_CODE.name, null, null);
		LNumber hashCodeAsNumber = hashCodeAsUnit.asType(LTypes.NUMBER);

		if (hashCodeAsNumber != null) return Double.hashCode(hashCodeAsNumber.value);

		return hashCodeAsUnit.hashCode();
	}

	public int _hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object object)
	{
		if (!(object instanceof LUnit)) return false;

		return callMember(LUnitMember.EQUALS.name, new LUnit[] {(LUnit)object}, null).toBoolean();
	}

	public boolean _equals(LUnit unit)
	{
		return super.equals(unit);
	}

	@Override
	public String toString()
	{
		LUnit stringAsUnit = callMember(LUnitMember.TO_STRING.name, null, null);
		LString string = stringAsUnit.asType(LTypes.STRING);

		if (string != null) return string.getValue();

		return stringAsUnit.toString();
	}

	public String _toString()
	{
		return getType()._toString();
	}

	public boolean toBoolean()
	{	//=> members
		return _toBoolean().getValue();
	}

	public LBoolean _toBoolean()
	{
		LBoolean thisAsBoolean = asType(LTypes.BOOLEAN);

		if (thisAsBoolean != null) return thisAsBoolean.getValue() ? LTrue.instance : LFalse.instance;
		else
		{
			boolean boolean_ = (
				this != LVoid.instance &&
				this != LNone.instance &&
				this != LUndefined.instance &&
				(
					asType(LTypes.NUMBER) == null || ((LNumber)asType(LTypes.NUMBER)).value != 0
				)
			);

			return boolean_ ? LTrue.instance : LFalse.instance;
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*Constant Methods on Internal Level                                                                              */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public LType getType()
	{
		return type;
    }

	public static LUnit getPrototype()
	{
		initPrototypeIfNecessary();
		return prototype;
	}

	@Nullable
	public Map<String, Integer> getParameterIndexes()
	{
		return parameterIndexes;
	}

	@Nullable
	public LUnitContext getCapturedOnCreationUnitContext()
	{
		return capturedOnCreationUnitContext;
	}

	public LUnit getSuperMember(String superMemberName)
	{
		for (Iterator<LUnit> parentIterator = initParentsIfNecessary().descendingIterator(); parentIterator.hasNext();)
		{
			LUnit parent = parentIterator.next();

			LUnit member = parent.getMember(superMemberName);

			if (member != LUndefined.instance) return member;
		}

		return LUndefined.instance;
	}

	public LUnit instantiate(
		@Nullable LUnit[] parameters, @Nullable LUnitContext unitContext, @Nullable Consumer<LUnit> saver
	)
	{
		LUnit self = this;

		LUnit newUnit = new LUnit(new LType(getType().name), getCapturedOnCreationUnitContext())
		{
			@Override
			public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
			{
				return self.call(host, parameters, unitContext);
			}
		};

		if (saver != null) saver.accept(newUnit);

		newUnit.addParent(this);

		call(newUnit, parameters, unitContext);

		return newUnit;
	}

	public LUnit addParent(LUnit parent)
	{
		initParentsIfNecessary().add(parent);

		return this;
	}

	@Nullable
	public <TYPE extends LUnit> TYPE asType(LType type)
	{
		if (getType() == type) return (TYPE)this;

		for (Iterator<LUnit> parentIterator = initParentsIfNecessary().descendingIterator(); parentIterator.hasNext();)
		{
			LUnit parent = parentIterator.next();

			LUnit parentAsType = parent.asType(type);

			if (parentAsType != null) return (TYPE)parentAsType;
		}

		return null;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*Internal helpers                                                                                                */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Internal
	protected LUnit checkCallParameter(@Nullable LUnit[] parameters, int parameterIndex)
	{
		if (parameters != null && parameterIndex >= 0 && parameterIndex < parameters.length)
			return parameters[parameterIndex];

		LErrors.parameterIsMissedForUnit(parameterIndex, this);

		return null;
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
				addParent(prototype);
			}
		}

		return parents;
	}

	@Internal
	private ConcurrentMap<String, LUnit> initMembersIfNecessary()
	{
		if (members == null) synchronized(this)
		{
			if (members == null)
				members = new ConcurrentHashMap<>(
					LSettings.UNIT_MEMBERS_INITIAL_CAPACITY,
					LSettings.UNIT_MEMBERS_LOAD_FACTOR,
					LSettings.UNIT_MEMBERS_CONCURRENCY_LEVEL
				);
		}

		return members;
	}

	@Internal
	private static void initPrototypeIfNecessary()
	{
		if (prototype == null) synchronized(LUnit.class)
		{
			if (prototype == null)
				prototype = new LUnit(new LType(LDataUnit.UNIT_PROTOTYPE.name))
				{
					{
						initializeBuiltins();
					}

					@Override
					public LUnit getSuperMember(String superMemberName)
					{
						return LUndefined.instance;
					}

					@Override
					protected ConcurrentLinkedDeque<LUnit> initParentsIfNecessary()
					{
						if (parents == null) synchronized(this)
						{
							if (parents == null) parents = new ConcurrentLinkedDeque<>();
						}

						return parents;
					}

					private void initializeBuiltins()
					{
						LNew.instance.init(this);
						LAddParent.instance.init(this);
						LGetIndexItem.instance.init(this);
						LSetIndexItem.instance.init(this);
						LGetType.instance.init(this);
						LToString.instance.init(this);
						LHashCode.instance.init(this);
						LEquals.instance.init(this);
						LUnitEqualsEquals.instance.init(this);
						LUnitBangEquals.instance.init(this);
					}
				};
		}
	}
}