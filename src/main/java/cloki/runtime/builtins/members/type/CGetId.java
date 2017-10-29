package cloki.runtime.builtins.members.type;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.constant.LType;
import cloki.runtime.constant.LTypeMember;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;

public class CGetId extends CMember
{
	public static CGetId instance = new CGetId();

	private CGetId()
	{
		super(new cloki.runtime.datatype.LType(LTypeMember.GET_ID.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		if (host instanceof cloki.runtime.datatype.LType) return new LNumber(((cloki.runtime.datatype.LType)host).id);

		LErrors.printErrorUnitDoesNotBelongToType(host, LType.TYPE.name);
		return LUndefined.instance;
	}
}
