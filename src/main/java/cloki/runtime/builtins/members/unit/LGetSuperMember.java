package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.LMember;
import cloki.runtime.constant.LTypes;
import cloki.runtime.constant.LUnitMember;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.LString;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.utils.Nullable;

public class LGetSuperMember extends LMember
{
	public static final LGetSuperMember instance = new LGetSuperMember();

	private LGetSuperMember()
	{
		super(new LType(LUnitMember.GET_SUPER_MEMBER.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		LUnit superMemberNameAsUnit = checkCallParameter(parameters, 0);
		LString superMemberAsString = superMemberNameAsUnit.asType(LTypes.STRING);

		if (superMemberAsString != null) host.getSuperMember(superMemberAsString.getValue());

		return host.getSuperMember(superMemberNameAsUnit.toString());
	}
}
