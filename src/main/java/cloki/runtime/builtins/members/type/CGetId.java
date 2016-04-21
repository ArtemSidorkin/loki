package cloki.runtime.builtins.members.type;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.CConstType;
import cloki.runtime.consts.CConstTypeMember;
import cloki.runtime.datatypes.CNumber;
import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUndefined;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.CErrors;
import cloki.runtime.utils.Nullable;

public class CGetId extends CMember
{
	public static CGetId instance = new CGetId();

	private CGetId()
	{
		super(new CType(CConstTypeMember.GET_ID.name));
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		if (host instanceof CType) return new CNumber(((CType)host).id);

		CErrors.printErrorUnitDoesNotBelongToType(host, CConstType.TYPE.name);
		return CUndefined.instance;
	}
}
