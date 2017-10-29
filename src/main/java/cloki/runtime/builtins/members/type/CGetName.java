package cloki.runtime.builtins.members.type;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.CConstType;
import cloki.runtime.consts.CConstTypeMember;
import cloki.runtime.datatype.LString;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.LErrors;

public class CGetName extends CMember
{
	public static CGetName instance = new CGetName();

	public CGetName()
	{
		super(new LType(CConstTypeMember.GET_NAME.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters, LUnitContext unitContext)
	{
		if (host instanceof LType) return new LString(((LType)host).getName());

		LErrors.printErrorUnitDoesNotBelongToType(host, CConstType.TYPE.name);
		return LUndefined.instance;
	}
}
