package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.CConstUnitMember;
import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.Nullable;

public class CNew extends CMember
{
	public static final CNew instance = new CNew();

	private CNew()
	{
		super(new CType(CConstUnitMember.NEW.name));
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		return host.instantiate(parameters, unitContext, null);
	}
}
