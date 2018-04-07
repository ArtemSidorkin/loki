package loki.runtime.datatype.type.member.internal;

import loki.runtime.constant.LTypeMember;
import loki.runtime.datatype.LString;
import loki.runtime.datatype.unit.LUnit;

public class LGetNameTypeInternalMember extends LTypeInternalMember
{
	public static final LGetNameTypeInternalMember instance = new LGetNameTypeInternalMember();

	private LGetNameTypeInternalMember()
	{
		super(LTypeMember.GET_NAME.name);
	}

	@Override
	public LUnit apply(String name, long id, LUnit[] parameters)
	{
		return new LString(name);
	}
}
