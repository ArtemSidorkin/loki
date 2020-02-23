package loki.runtime.unit.unit.member;

import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LEquals extends LMember
{
	public static final String TYPE_NAME = "equals";
	public static final LType TYPE = new LType(TYPE_NAME, LEquals.class);

	public static final LEquals INSTANCE = new LEquals();

	private LEquals()
	{
		super(TYPE);
	}

	@Override
	public LBoolean call(LUnit host, LUnit[] parameters)
	{
		return host._equals(checkCallParameter(parameters, 0));
	}
}
