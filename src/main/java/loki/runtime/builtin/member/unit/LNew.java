package loki.runtime.builtin.member.unit;

import loki.runtime.builtin.member.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LType;
import loki.runtime.datatype.LUnit;
import loki.runtime.util.Nullable;

public class LNew extends LMember
{
	public static final LNew instance = new LNew();

	private LNew()
	{
		super(new LType(LUnitMember.NEW.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return host.instantiate(parameters, unitContext, null);
	}
}
