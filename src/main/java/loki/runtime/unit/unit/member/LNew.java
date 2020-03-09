package loki.runtime.unit.unit.member;

import loki.runtime.unit.member.LMember;
import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;

public class LNew extends LMember
{
	public static final String TYPE_NAME = "new";
	public static final LType TYPE = new LType(TYPE_NAME, LNew.class);

	public static final LNew INSTANCE = new LNew();

	private LNew()
	{
		super(TYPE);
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return host.newInstance(parameters, null);
	}
}
