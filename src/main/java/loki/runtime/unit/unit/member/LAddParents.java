package loki.runtime.unit.unit.member;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LAddParents extends LMember
{
	public static final String TYPE_NAME = "addParents";
	public static final LType TYPE = new LType(TYPE_NAME, LAddParents.class);

	public static final LAddParents INSTANCE = new LAddParents();

	private LAddParents()
	{
		super(TYPE);
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		host._addParents(parameters);

		return host;
	}
}
