package loki.runtime.builtin.member.unit;

import loki.runtime.builtin.member.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LString;
import loki.runtime.datatype.LUnit;
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
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return new LString(host._toString());
	}
}
