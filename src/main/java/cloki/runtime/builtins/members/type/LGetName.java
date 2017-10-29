package cloki.runtime.builtins.members.type;

import cloki.runtime.builtins.members.LMember;
import cloki.runtime.constant.LTypeMember;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.LString;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.utils.LErrors;

public class LGetName extends LMember
{
	public static LGetName instance = new LGetName();

	public LGetName()
	{
		super(new LType(LTypeMember.GET_NAME.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters, LUnitContext unitContext)
	{
		if (host instanceof LType) return new LString(((LType)host).getName());

		LErrors.printErrorUnitDoesNotBelongToType(host, cloki.runtime.constant.LType.TYPE.name);
		return LUndefined.instance;
	}
}
