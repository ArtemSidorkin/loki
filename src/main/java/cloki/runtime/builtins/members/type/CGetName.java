package cloki.runtime.builtins.members.type;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.CConstType;
import cloki.runtime.consts.CConstTypeMember;
import cloki.runtime.datatypes.CString;
import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUndefined;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.CErrors;

public class CGetName extends CMember
{
	public static CGetName instance = new CGetName();

	public CGetName()
	{
		super(new CType(CConstTypeMember.GET_NAME.name));
	}

	@Override
	public CUnit call(CUnit host, CUnit[] parameters, CUnitContext unitContext)
	{
		if (host instanceof CType) return new CString(((CType)host).getName());

		CErrors.printErrorUnitDoesNotBelongToType(host, CConstType.TYPE.name);
		return CUndefined.instance;
	}
}
