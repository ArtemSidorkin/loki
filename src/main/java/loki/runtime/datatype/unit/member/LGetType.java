package loki.runtime.datatype.unit.member;

import loki.runtime.datatype.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.unit.LUnit;
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
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		return host.getType();
	}
}
