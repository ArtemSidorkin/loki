package loki.runtime.datatype.number.member.internal;

import loki.runtime.constant.LUnitMember;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LHashCodeNumberInternalMember extends LNumberInternalMember
{
	public static final LHashCodeNumberInternalMember instance = new LHashCodeNumberInternalMember();

	private LHashCodeNumberInternalMember()
	{
		super(LUnitMember.HASH_CODE.name);
	}

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		return new LNumber(Double.hashCode(value));
	}
}
