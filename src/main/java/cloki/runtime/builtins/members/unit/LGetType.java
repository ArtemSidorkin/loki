package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.LMember;
import cloki.runtime.constant.LUnitMember;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.utils.Nullable;

public class LGetType extends LMember
{
	public static final LGetType instance = new LGetType();

	private LGetType()
	{
		super(new LType(LUnitMember.GET_TYPE.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return host.getType();
	}
}
