package loki.runtime.builtin.member.type;

import loki.runtime.builtin.member.LMember;
import loki.runtime.constant.LTypeMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LType;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.util.LErrors;
import loki.runtime.util.Nullable;

public class LGetId extends LMember
{
	public static LGetId instance = new LGetId();

	private LGetId()
	{
		super(new LType(LTypeMember.GET_ID.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		if (host instanceof LType) return new LNumber(((LType)host).id);

		LErrors.printErrorUnitDoesNotBelongToType(host, loki.runtime.constant.LType.TYPE.name);
		return LUndefined.instance;
	}
}
