package loki.runtime.unit.unit.member;

import loki.runtime.constant.LUnitMember;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LNew extends LMember
{
	public static final LNew instance = new LNew();

	private LNew()
	{
		super(new LType(LUnitMember.NEW.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return host.newInstance(parameters, null);
	}
}
