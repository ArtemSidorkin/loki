package loki.runtime.unit.unit.member;

import loki.runtime.constant.LUnitMember;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LEquals extends LMember
{
	public static final LEquals instance = new LEquals();

	private LEquals()
	{
		super(new LType(LUnitMember.EQUALS.name));
	}

	@Override
	public LBoolean call(LUnit host, LUnit[] parameters)
	{
		return host._equals(checkCallParameter(parameters, 0));
	}
}
