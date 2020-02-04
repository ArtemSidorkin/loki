package loki.runtime.unit.unit.member;

import loki.runtime.constant.LUnitMember;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.Nullable;

public class LToBoolean extends LMember
{
	public static final LToBoolean instance = new LToBoolean();

	private LToBoolean()
	{
		super(new LType(LUnitMember.TO_BOOLEAN.name));
	}

	@Override
	public LBoolean call(LUnit host, @Nullable LUnit[] parameters)
	{
		return host._toBoolean();
	}
}
