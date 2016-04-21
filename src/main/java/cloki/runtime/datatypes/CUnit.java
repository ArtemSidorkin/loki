package cloki.runtime.datatypes;

import cloki.runtime.CSettings;
import cloki.runtime.builtins.CBuiltins;
import cloki.runtime.consts.CConstDataUnit;
import cloki.runtime.consts.CConstTypes;
import cloki.runtime.consts.CConstUnitMember;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.CErrors;
import cloki.runtime.utils.Nullable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;
import java.util.function.Function;

abstract public class CUnit
{
	private static volatile CUnit prototype;

	protected final Object guard = new Object();
	@Nullable protected volatile CUnitContext unitContext;

	private final CType type;
	@Nullable private volatile ConcurrentLinkedDeque<CUnit> parents;
	@Nullable private volatile ConcurrentMap<String, CUnit> members;
	@Nullable private volatile Map<String, Integer> parameters;

	public CUnit(CType type)
	{
		this(type, (CUnitContext)null);
	}

	public CUnit(CType type, @Nullable CUnitContext unitContext)
	{
		this.type = type;
		this.unitContext = unitContext;
	}

	protected CUnit(CType type, Function<CUnit, CUnitContext> unitContextFunction)
	{
		this.type = type;
		this.unitContext = unitContextFunction.apply(this);
	}

	public static CUnit getUnitPrototype()
	{
		initPrototypeIfNeeded();
		return prototype;
	}

	private static void initPrototypeIfNeeded()
	{
		if (prototype == null) synchronized(CUnit.class)
		{
			if (prototype == null)
			{
				prototype = new CUnit(new CType(CConstDataUnit.UNIT_PROTOTYPE.name))
				{
					{
						CBuiltins.initUnitPrototype(this);
					}

					@Override
					public CUnit getSuperMember(String superMemberName)
					{
						return CUndefined.instance;
					}

					@Override
					protected void initParentsIfNeeded() {}
				};
			}
		}
	}

	public CType getType()
	{
		return type;
	}

	@Nullable
	public CUnitContext getUnitContext()
	{
		return unitContext;
	}

	@Nullable
	public Map<String, Integer> getParameters()
	{
		return parameters;
	}

	public CUnit addParent(CUnit parent)
	{
		initParentsIfNeeded();
		parents.add(parent);
		return this;
	}

	public CUnit getSuperMember(String superMemberName)
	{
		initParentsIfNeeded();

		for (Iterator<CUnit> i = parents.descendingIterator(); i.hasNext();)
		{
			CUnit prnt = i.next();
			if (prnt != null)
			{
				CUnit mmbr = prnt.getMember(superMemberName);
				if (mmbr != CUndefined.instance) return mmbr;
			}
		}

		return CUndefined.instance;
	}

	public CUnit getMember(String memberName)
	{
		if (members != null)
		{
			CUnit mmbr = members.get(memberName);
			if (mmbr != null) return mmbr;
		}

		return getSuperMember(memberName);
	}

	public CUnit setMember(String memberName, CUnit member)
	{
		initMembersIfNeeded();
		members.put(memberName, member);
		return member;
	}

	public CUnit getIndexedItem(@Nullable CUnit[] parameters)
	{
		return callMember(CConstUnitMember.GET_INDEX_ITEM.name, parameters, null);
	}

	public CUnit _getIndexedItem(@Nullable CUnit[] parameters)
	{
		return CUndefined.instance;
	}

	public CUnit setIndexedItem(@Nullable CUnit[] parameters)
	{
		return callMember(CConstUnitMember.SET_INDEX_ITEM.name, parameters, null);
	}

	public CUnit _setIndexedItem(@Nullable CUnit[] parameters)
	{
		return CUndefined.instance;
	}

	public CUnit setParameterNames(@Nullable String[] parameterNames)
	{
		HashMap<String, Integer> prmtrs = new HashMap<>
		(
			CSettings.UNIT_PARAMETER_NAMES_INITIAL_CAPACITY, CSettings.UNIT_PARAMETER_NAMES_LOAD_FACTOR
		);

		for (int i = 0; i < parameterNames.length; i++)
			prmtrs.put(parameterNames[i], i);

		parameters = prmtrs;
		return this;
	}

	public CUnit instantiate
	(
		@Nullable CUnit[] parameters, @Nullable CUnitContext unitContext, @Nullable Consumer<CUnit> saver
	)
	{
		final CUnit self = this;

		CUnit nwUnt = new CUnit(new CType(getType().getName()), getUnitContext())
		{
			@Override
			public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
			{
				return self.call(host, parameters, unitContext);
			}
		};

		if (saver != null) saver.accept(nwUnt);

		nwUnt.addParent(this);
		call(nwUnt, parameters, unitContext);
		return nwUnt;
	}

	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		return CUndefined.instance;
	}

	public CUnit callMember(String memberName, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		return getMember(memberName).call(this, parameters, unitContext);
	}

	@Nullable
	public <T extends CUnit> T asType(CType type)
	{
		if (getType()._equals(type)) return (T)this;

		initParentsIfNeeded();
		if (parents == null) return null;
		for (Iterator<CUnit> i = parents.descendingIterator(); i.hasNext();)
		{
			CUnit prnt = i.next();
			if (prnt != null && prnt.asType(type) != null) return (T)prnt;
		}

		return null;
	}

	public boolean toBoolean()
	{//=> members
		return _toBoolean().getValue();
	}

	public CBoolean _toBoolean()
	{
		CBoolean thsAsBln = asType(CConstTypes.BOOLEAN);
		if (thsAsBln != null) return thsAsBln.getValue() ? CTrue.instance : CFalse.instance;
		else return
		(
			this != CVoid.instance &&
			this != CNone.instance &&
			this != CUndefined.instance &&
			(
				asType(CConstTypes.NUMBER) == null ||
				((CNumber)asType(CConstTypes.NUMBER)).getValue() != 0
			)
		) ? CTrue.instance : CFalse.instance;
	}

	@Override
	public String toString()
	{
		CUnit strngAsUnt = callMember(CConstUnitMember.TO_STRING.name, null, null);
		CString strng = strngAsUnt.asType(CConstTypes.STRING);
		if (strng != null) return strng.getValue();
		return strngAsUnt.toString();
	}

	public String _toString()
	{
		return type._toString();
	}

	@Override
	public int hashCode()
	{
		CUnit hshCdAsUnt = callMember(CConstUnitMember.HASH_CODE.name, null, null);
		CNumber hshCdAsNmbr = hshCdAsUnt.asType(CConstTypes.NUMBER);
		if (hshCdAsNmbr != null) return Double.hashCode(hshCdAsNmbr.getValue());
		return hshCdAsUnt.hashCode();
	}

	public int _hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object object)
	{
		if (!(object instanceof CUnit)) return false;

		CUnit eqlsAsUnt = callMember(CConstUnitMember.EQUALS.name, new CUnit[] {(CUnit)object}, null);
		CBoolean eqlsAsBln = eqlsAsUnt.asType(CConstTypes.BOOLEAN);
		if (eqlsAsBln != null) return eqlsAsBln instanceof CTrue;
		return
		(
			eqlsAsUnt != CVoid.instance && // method toBool
			eqlsAsUnt != CNone.instance &&
			eqlsAsUnt != CUndefined.instance &&
			(
				eqlsAsUnt.asType(CConstTypes.NUMBER) == null ||
				((CNumber)eqlsAsUnt.asType(CConstTypes.NUMBER)).getValue() != 0
			)
		);
	}

	public boolean _equals(CUnit unit)
	{
		return super.equals(unit);
	}

	protected CUnit checkCallParameter(@Nullable CUnit[] parameters, int parameterIndex)
	{
		if (parameters != null && parameterIndex >= 0 && parameterIndex < parameters.length)
			return parameters[parameterIndex];

		CErrors.printErrorParameterIsMissedForUnit(parameterIndex, this);
		return CUndefined.instance;
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
					CSettings.UNIT_MEMBERS_INITIAL_CAPACITY,
					CSettings.UNIT_MEMBERS_LOAD_FACTOR,
					CSettings.UNIT_MEMBERS_CONCURRENCY_LEVEL
				);
			}
		}
	}
}
