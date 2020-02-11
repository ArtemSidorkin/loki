package loki.runtime.unit.unit.member;

import loki.runtime.constant.LUnitMember;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LAddParents extends LMember
{
	public static final LAddParents instance = new LAddParents();

	private LAddParents()
	{
		super(new LType(LUnitMember.ADD_PARENTS.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		host._addParents(parameters);

		return host;
	}
}
