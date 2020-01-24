package loki.runtime.datatype.unit.member;

import loki.runtime.constant.LUnitMember;
import loki.runtime.datatype.LBoolean;
import loki.runtime.datatype.LMember;
import loki.runtime.datatype.type.LType;
import loki.runtime.datatype.unit.LUnit;
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
