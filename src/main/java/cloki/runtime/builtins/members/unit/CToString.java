package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.LConstUnitMember;
import cloki.runtime.datatype.LString;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

public class CToString extends CMember
{
	public static final CToString instance = new CToString();

	private CToString()
	{
		super(new LType(LConstUnitMember.TO_STRING.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return new LString(host._toString());
	}
}
