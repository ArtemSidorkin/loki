package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.CConstUnitMember;
import cloki.runtime.datatypes.CString;
import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.Nullable;

public class CToString extends CMember
{
	public static final CToString instance = new CToString();

	private CToString()
	{
		super(new CType(CConstUnitMember.TO_STRING.name));
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		return new CString(host._toString());
	}
}
