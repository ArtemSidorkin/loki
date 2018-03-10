package loki.runtime.builtins.members.unit;

import loki.runtime.builtins.members.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LType;
import loki.runtime.datatype.LUnit;
import loki.runtime.utils.Nullable;

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
