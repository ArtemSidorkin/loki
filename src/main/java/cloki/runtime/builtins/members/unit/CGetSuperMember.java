package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.CConstTypes;
import cloki.runtime.consts.LConstUnitMember;
import cloki.runtime.datatype.LString;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

public class CGetSuperMember extends CMember
{
	public static final CGetSuperMember instance = new CGetSuperMember();

	private CGetSuperMember()
	{
		super(new LType(LConstUnitMember.GET_SUPER_MEMBER.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		LUnit sprMmbrNmAsUnt = checkCallParameter(parameters, 0);
		LString sprMmbrNmAsStr = sprMmbrNmAsUnt.asType(CConstTypes.STRING);
		if (sprMmbrNmAsStr != null) host.getSuperMember(sprMmbrNmAsStr.getValue());
		return host.getSuperMember(sprMmbrNmAsUnt.toString());
	}
}
