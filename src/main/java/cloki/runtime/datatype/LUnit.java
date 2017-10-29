package cloki.runtime.datatype;

import cloki.runtime.LSettings;
import cloki.runtime.builtins.LBuiltins;
import cloki.runtime.constant.LTypes;
import cloki.runtime.constant.LDataUnit;
import cloki.runtime.constant.LUnitMember;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;

abstract public class LUnit
{
	private static volatile LUnit prototype;

	@Nullable protected volatile LUnitContext unitContext;

	protected final Object guard = new Object();

	private final LType type;
	@Nullable private volatile ConcurrentLinkedDeque<LUnit> parents;
	@Nullable private volatile ConcurrentMap<String, LUnit> members;
	@Nullable private volatile Map<String, Integer> parameterIndexes;

	public LUnit(LType type)
	{
		this(type, null);
	}

	public LUnit(LType type, @Nullable LUnitContext unitContext)
	{
		this.type = type;
		this.unitContext = unitContext;
	}

	public static LUnit getPrototype()
	{
		initPrototypeIfNeeded();
		return prototype;
	}

	private static void initPrototypeIfNeeded()
	{
		if (prototype == null) synchronized(LUnit.class)
		{
			if (prototype == null)
				prototype = new LUnit(new LType(LDataUnit.UNIT_PROTOTYPE.name))
				{
					{
						LBuiltins.initUnitPrototype(this);
					}

					@Override
					public LUnit getSuperMember(String superMemberName)
					{
						return LUndefined.instance;
					}

					@Override
					protected void initParentsIfNeeded() {}
				};
		}
	}

	public LType getType()
	{
		return type;
	}

	@Nullable
	public LUnitContext getUnitContext()
	{
		return unitContext;
	}

	@Nullable
	public Map<String, Integer> getParameterIndexes()
	{
		return parameterIndexes;
	}

	public LUnit addParent(LUnit parent)
	{
		initParentsIfNeeded();
		parents.add(parent);
		return this;
	}

	public LUnit getSuperMember(String superMemberName)
	{
		initParentsIfNeeded();

		for (Iterator<LUnit> parentIterator = parents.descendingIterator(); parentIterator.hasNext();)
		{
			LUnit parent = parentIterator.next();

			if (parent != null)
			{
				LUnit member = parent.getMember(superMemberName);

				if (member != LUndefined.instance) return member;
			}
		}

		return LUndefined.instance;
	}

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
		initMembersIfNeeded();
		members.put(memberName, member);
		return member;
	}

	public LUnit getIndexedItem(@Nullable LUnit[] parameters)
	{
		return callMember(LUnitMember.GET_INDEX_ITEM.name, parameters, null);
	}

	public LUnit _getIndexedItem(@Nullable LUnit[] parameters)
	{
		return LUndefined.instance;
	}

	public LUnit setIndexedItem(@Nullable LUnit[] parameters)
	{
		return callMember(LUnitMember.SET_INDEX_ITEM.name, parameters, null);
	}

	public LUnit _setIndexedItem(@Nullable LUnit[] parameters)
	{
		return LUndefined.instance;
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

	public LUnit instantiate(
		@Nullable LUnit[] parameters, @Nullable LUnitContext unitContext, @Nullable Consumer<LUnit> saver
	)
	{
		LUnit self = this;

		LUnit newUnit = new LUnit(new LType(getType().getName()), getUnitContext())
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

	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return LUndefined.instance;
	}

	public LUnit callMember(String memberName, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return getMember(memberName).call(this, parameters, unitContext);
	}

	@Nullable
	public <T extends LUnit> T asType(LType type)
	{
		if (getType()._equals(type)) return (T)this;

		initParentsIfNeeded();

		if (parents == null) return null;

		for (Iterator<LUnit> parentIterator = parents.descendingIterator(); parentIterator.hasNext();)
		{
			LUnit parent = parentIterator.next();

			if (parent != null && parent.asType(type) != null) return (T)parent;
		}

		return null;
	}

	public boolean toBoolean()
	{//=> members
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
					asType(LTypes.NUMBER) == null || ((LNumber)asType(LTypes.NUMBER)).getValue() != 0
				)
			);

			return boolean_ ? LTrue.instance : LFalse.instance;
		}

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
		return type._toString();
	}

	@Override
	public int hashCode()
	{
		LUnit hashCodeAsUnit = callMember(LUnitMember.HASH_CODE.name, null, null);
		LNumber hashCodeAsNumber = hashCodeAsUnit.asType(LTypes.NUMBER);

		if (hashCodeAsNumber != null) return Double.hashCode(hashCodeAsNumber.getValue());

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

	protected LUnit checkCallParameter(@Nullable LUnit[] parameters, int parameterIndex)
	{
		if (parameters != null && parameterIndex >= 0 && parameterIndex < parameters.length)
			return parameters[parameterIndex];

		LErrors.printErrorParameterIsMissedForUnit(parameterIndex, this);
		return LUndefined.instance;
	}

	protected void initParentsIfNeeded()
	{
		if (parents == null) synchronized(guard)
		{
			if (parents == null)
			{
				parents = new ConcurrentLinkedDeque<>();
				initPrototypeIfNeeded();
				addParent(prototype);
			}
		}
	}

	private void initMembersIfNeeded()
	{
		if (members == null) synchronized(guard)
		{
			if (members == null)
			{
				members = new ConcurrentHashMap<>
				(
					LSettings.UNIT_MEMBERS_INITIAL_CAPACITY,
					LSettings.UNIT_MEMBERS_LOAD_FACTOR,
					LSettings.UNIT_MEMBERS_CONCURRENCY_LEVEL
				);
			}
		}
	}
}
