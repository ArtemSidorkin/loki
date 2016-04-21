package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.CConstUnitMember;
import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.Nullable;

public class CAddParent extends CMember
{
	public static final CAddParent instance = new CAddParent();

	private CAddParent()
	{
		super(new CType(CConstUnitMember.ADD_PARENT.name));
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		return host.addParent(checkCallParameter(parameters, 0));
	}
}
