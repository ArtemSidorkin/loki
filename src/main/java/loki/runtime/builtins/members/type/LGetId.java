package loki.runtime.builtins.members.type;

import loki.runtime.builtins.members.LMember;
import loki.runtime.constant.LTypeMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.LType;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.utils.LErrors;
import loki.runtime.utils.Nullable;

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
