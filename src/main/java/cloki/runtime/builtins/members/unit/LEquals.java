package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.LMember;
import cloki.runtime.constant.LUnitMember;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.utils.Nullable;

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
