package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.LConstUnitMember;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

public class CEquals extends CMember
{
	public static final CEquals instance = new CEquals();

	private CEquals()
	{
		super(new LType(LConstUnitMember.EQUALS.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return host._equals(checkCallParameter(parameters, 0)) ? LTrue.instance : LFalse.instance;
	}
}
