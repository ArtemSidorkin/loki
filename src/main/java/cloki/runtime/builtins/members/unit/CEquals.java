package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.CConstUnitMember;
import cloki.runtime.datatypes.CFalse;
import cloki.runtime.datatypes.CTrue;
import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.Nullable;

public class CEquals extends CMember
{
	public static final CEquals instance = new CEquals();

	private CEquals()
	{
		super(new CType(CConstUnitMember.EQUALS.name));
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		return host._equals(checkCallParameter(parameters, 0)) ? CTrue.instance : CFalse.instance;
	}
}
