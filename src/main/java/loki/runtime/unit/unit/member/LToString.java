package loki.runtime.unit.unit.member;

import loki.runtime.constant.LUnitMember;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LToString extends LMember
{
	public static final LToString instance = new LToString();

	private LToString()
	{
		super(new LType(LUnitMember.TO_STRING.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return host._toString();
	}
}
