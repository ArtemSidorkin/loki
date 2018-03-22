package loki.runtime.builtin.member.unit;

import loki.runtime.builtin.member.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.type.LType;
import loki.runtime.util.Nullable;

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
