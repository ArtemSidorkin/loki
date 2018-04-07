package loki.runtime.datatype.type.member.internal;

import loki.runtime.constant.LTypeMember;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LGetIdTypeInternalMember extends LTypeInternalMember
{
	public static final LGetIdTypeInternalMember instance = new LGetIdTypeInternalMember();

	private LGetIdTypeInternalMember()
	{
		super(LTypeMember.GET_ID.name);
	}

	@Override
	public LUnit apply(String name, long id, LUnit[] parameters)
	{
		return new LNumber(id);
	}
}
