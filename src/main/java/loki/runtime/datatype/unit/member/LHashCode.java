package loki.runtime.datatype.unit.member;

import loki.runtime.datatype.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.unit.LUnit;
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
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		return host._hashCode();
	}
}
