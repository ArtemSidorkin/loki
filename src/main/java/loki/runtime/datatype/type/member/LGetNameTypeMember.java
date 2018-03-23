package loki.runtime.datatype.type.member;

import loki.runtime.builtin.member.LMember;
import loki.runtime.constant.LTypeMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LString;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.type.LType;
import loki.runtime.util.LErrors;

public class LGetNameTypeMember extends LMember
{
	public static LGetNameTypeMember instance = new LGetNameTypeMember();

	private LGetNameTypeMember()
	{
		super(new LType(LTypeMember.GET_NAME.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters, LUnitContext unitContext)
	{
		if (host instanceof LType) return new LString(((LType)host).name);

		LErrors.printErrorUnitDoesNotBelongToType(host, loki.runtime.constant.LType.TYPE.name);
		return LUndefined.instance;
	}
}