package loki.runtime.unit.unit.member;

import loki.runtime.constant.LUnitMember;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LGetType extends LMember
{
	public static final LGetType instance = new LGetType();

	private LGetType()
	{
		super(new LType(LUnitMember.GET_TYPE.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return host.getType();
	}
}
