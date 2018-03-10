package loki.runtime.builtin.member.unit;

import loki.runtime.builtin.member.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LType;
import loki.runtime.datatype.LUnit;
import loki.runtime.util.Nullable;

public class LEquals extends LMember
{
	public static final LEquals instance = new LEquals();

	private LEquals()
	{
		super(new LType(LUnitMember.EQUALS.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return host._equals(checkCallParameter(parameters, 0)) ? LTrue.instance : LFalse.instance;
	}
}
