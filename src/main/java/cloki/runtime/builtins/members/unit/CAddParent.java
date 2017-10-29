package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.LConstUnitMember;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

public class CAddParent extends CMember
{
	public static final CAddParent instance = new CAddParent();

	private CAddParent()
	{
		super(new LType(LConstUnitMember.ADD_PARENT.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return host.addParent(checkCallParameter(parameters, 0));
	}
}
