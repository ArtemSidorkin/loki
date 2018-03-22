package loki.runtime.datatype.type.member.internal;

import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LHashCodeTypeInternalMember extends LTypeInternalMember
{
	public static final LHashCodeTypeInternalMember instance = new LHashCodeTypeInternalMember();

	@Override
	public LUnit apply(String name, long id, LUnit[] parameters)
	{
		return new LNumber(Long.hashCode(id));
	}
}
