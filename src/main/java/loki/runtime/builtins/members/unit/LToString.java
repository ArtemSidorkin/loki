package loki.runtime.builtins.members.unit;

import loki.runtime.builtins.members.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LString;
import loki.runtime.datatype.LType;
import loki.runtime.datatype.LUnit;
import loki.runtime.utils.Nullable;

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
