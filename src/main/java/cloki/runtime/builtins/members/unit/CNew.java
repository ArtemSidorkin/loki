package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.LConstUnitMember;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

public class CNew extends CMember
{
	public static final CNew instance = new CNew();

	private CNew()
	{
		super(new LType(LConstUnitMember.NEW.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return host.instantiate(parameters, unitContext, null);
	}
}
