package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.CConstTypes;
import cloki.runtime.consts.CConstUnitMember;
import cloki.runtime.datatypes.CString;
import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.Nullable;

public class CGetSuperMember extends CMember
{
	public static final CGetSuperMember instance = new CGetSuperMember();

	private CGetSuperMember()
	{
		super(new CType(CConstUnitMember.GET_SUPER_MEMBER.name));
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		CUnit sprMmbrNmAsUnt = checkCallParameter(parameters, 0);
		CString sprMmbrNmAsStr = sprMmbrNmAsUnt.asType(CConstTypes.STRING);
		if (sprMmbrNmAsStr != null) host.getSuperMember(sprMmbrNmAsStr.getValue());
		return host.getSuperMember(sprMmbrNmAsUnt.toString());
	}
}
