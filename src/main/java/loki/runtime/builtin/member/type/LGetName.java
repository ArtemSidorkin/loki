package loki.runtime.builtin.member.type;

import loki.runtime.builtin.member.LMember;
import loki.runtime.constant.LTypeMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LString;
import loki.runtime.datatype.LType;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.util.LErrors;

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

		LErrors.printErrorUnitDoesNotBelongToType(host, loki.runtime.constant.LType.TYPE.name);
		return LUndefined.instance;
	}
}
