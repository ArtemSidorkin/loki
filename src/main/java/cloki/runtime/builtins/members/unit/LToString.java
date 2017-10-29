package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.LMember;
import cloki.runtime.constant.LUnitMember;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.LString;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.utils.Nullable;

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
