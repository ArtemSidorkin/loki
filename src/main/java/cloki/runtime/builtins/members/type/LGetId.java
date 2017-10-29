package cloki.runtime.builtins.members.type;

import cloki.runtime.builtins.members.LMember;
import cloki.runtime.constant.LTypeMember;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;

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

		LErrors.printErrorUnitDoesNotBelongToType(host, cloki.runtime.constant.LType.TYPE.name);
		return LUndefined.instance;
	}
}
