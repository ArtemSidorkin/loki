package loki.runtime.datatype.unit.member;

import loki.runtime.datatype.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LString;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.type.LType;
import loki.runtime.util.Nullable;

public class LToString extends LMember
{
	public static final LToString instance = new LToString();

	private LToString()
	{
		super(new LType(LUnitMember.TO_STRING.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		return new LString(host._toString());
	}
}
