package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.LConstUnitMember;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

public class CGetType extends CMember
{
	public static final CGetType instance = new CGetType();

	private CGetType()
	{
		super(new LType(LConstUnitMember.GET_TYPE.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return host.getType();
	}
}
