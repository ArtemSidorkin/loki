package loki.runtime.builtin.member.unit;

import loki.runtime.builtin.member.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.type.LType;
import loki.runtime.util.Nullable;

public class LHashCode extends LMember
{
	public static final LHashCode instance = new LHashCode();

	private LHashCode()
	{
		super(new LType(LUnitMember.HASH_CODE.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return new LNumber(host._hashCode());
	}
}
