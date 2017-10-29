package cloki.runtime.builtins.members.type;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.constant.LType;
import cloki.runtime.constant.LTypeMember;
import cloki.runtime.datatype.LString;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.LErrors;

public class CGetName extends CMember
{
	public static CGetName instance = new CGetName();

	public CGetName()
	{
		super(new cloki.runtime.datatype.LType(LTypeMember.GET_NAME.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters, LUnitContext unitContext)
	{
		if (host instanceof cloki.runtime.datatype.LType) return new LString(((cloki.runtime.datatype.LType)host).getName());

		LErrors.printErrorUnitDoesNotBelongToType(host, LType.TYPE.name);
		return LUndefined.instance;
	}
}
