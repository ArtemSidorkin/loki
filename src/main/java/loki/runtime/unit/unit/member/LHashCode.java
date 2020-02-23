package loki.runtime.unit.unit.member;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LHashCode extends LMember
{
	public static final String TYPE_NAME = "hashCode";
	public static final LType TYPE = new LType(TYPE_NAME, LHashCode.class);

	public static final LHashCode INSTANCE = new LHashCode();

	private LHashCode()
	{
		super(TYPE);
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return host._hashCode();
	}
}
