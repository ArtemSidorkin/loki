package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.LMember;
import cloki.runtime.constant.LUnitMember;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.utils.Nullable;

public class LAddParent extends LMember
{
	public static final LAddParent instance = new LAddParent();

	private LAddParent()
	{
		super(new LType(LUnitMember.ADD_PARENT.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return host.addParent(checkCallParameter(parameters, 0));
	}
}
