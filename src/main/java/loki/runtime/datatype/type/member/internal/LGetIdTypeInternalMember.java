package loki.runtime.datatype.type.member.internal;

import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LGetIdTypeInternalMember extends LTypeInternalMember
{
	public static final LGetIdTypeInternalMember instance = new LGetIdTypeInternalMember();

	@Override
	public LUnit apply(String name, long id, LUnit[] parameters)
	{
		return new LNumber(id);
	}
}
