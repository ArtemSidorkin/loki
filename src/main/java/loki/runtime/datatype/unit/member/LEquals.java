package loki.runtime.datatype.unit.member;

import loki.runtime.datatype.LBoolean;
import loki.runtime.datatype.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.type.LType;
import loki.runtime.util.Nullable;

public class LEquals extends LMember
{
	public static final LEquals instance = new LEquals();

	private LEquals()
	{
		super(new LType(LUnitMember.EQUALS.name));
	}

	@Override
	public LBoolean call(LUnit host, @Nullable LUnit[] parameters)
	{
		return LBoolean.valueOf(host._equals(checkCallParameter(parameters, 0)));
	}
}
