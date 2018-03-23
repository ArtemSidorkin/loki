package loki.runtime.datatype.type.member.internal;

import loki.runtime.constant.LUnitMember;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LHashCodeTypeInternalMember extends LTypeInternalMember
{
	public static final LHashCodeTypeInternalMember instance = new LHashCodeTypeInternalMember();

	private LHashCodeTypeInternalMember()
	{
		super(LUnitMember.HASH_CODE.name);
	}

	@Override
	public LUnit apply(String name, long id, LUnit[] parameters)
	{
		return new LNumber(Long.hashCode(id));
	}
}
