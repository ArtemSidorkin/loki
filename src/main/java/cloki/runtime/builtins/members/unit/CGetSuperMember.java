package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.constant.LTypes;
import cloki.runtime.constant.LUnitMember;
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
		super(new LType(LUnitMember.GET_SUPER_MEMBER.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		LUnit sprMmbrNmAsUnt = checkCallParameter(parameters, 0);
		LString sprMmbrNmAsStr = sprMmbrNmAsUnt.asType(LTypes.STRING);
		if (sprMmbrNmAsStr != null) host.getSuperMember(sprMmbrNmAsStr.getValue());
		return host.getSuperMember(sprMmbrNmAsUnt.toString());
	}
}
