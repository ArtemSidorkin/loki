package loki.runtime.datatype.number.member.internal;

import loki.runtime.constant.LUnitMember;
import loki.runtime.datatype.LString;
import loki.runtime.datatype.unit.LUnit;

public class LToStringNumberInternalMember extends LNumberInternalMember
{
	public static final LToStringNumberInternalMember instance = new LToStringNumberInternalMember();

	private LToStringNumberInternalMember()
	{
		super(LUnitMember.TO_STRING.name);
	}

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		return new LString(value == Math.floor(value) ? String.valueOf((long)value) : String.valueOf(value));
	}
}
