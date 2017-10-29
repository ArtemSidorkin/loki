package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.LConstUnitMember;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

public class CHashCode extends CMember
{
	public static final CHashCode instance = new CHashCode();

	private CHashCode()
	{
		super(new LType(LConstUnitMember.HASH_CODE.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return new LNumber(host._hashCode());
	}
}
