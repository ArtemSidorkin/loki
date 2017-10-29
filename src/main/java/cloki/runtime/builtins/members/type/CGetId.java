package cloki.runtime.builtins.members.type;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.CConstType;
import cloki.runtime.consts.CConstTypeMember;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LType;
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
		super(new LType(CConstTypeMember.GET_ID.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		if (host instanceof LType) return new LNumber(((LType)host).id);

		LErrors.printErrorUnitDoesNotBelongToType(host, CConstType.TYPE.name);
		return LUndefined.instance;
	}
}
