package loki.runtime.unit.unit.member;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LToString extends LMember
{
	public static final String TYPE_NAME = "toString";
	public static final LType TYPE = new LType(TYPE_NAME, LToString.class);

	public static final LToString INSTANCE = new LToString();

	private LToString()
	{
		super(TYPE);
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return host._toString();
	}
}
