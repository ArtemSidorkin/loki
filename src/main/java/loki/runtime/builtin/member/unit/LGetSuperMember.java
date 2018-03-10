package loki.runtime.builtin.member.unit;

import loki.runtime.builtin.member.LMember;
import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LString;
import loki.runtime.datatype.LType;
import loki.runtime.datatype.LUnit;
import loki.runtime.util.Nullable;

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
