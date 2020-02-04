package loki.runtime.unit.unit.member;

import loki.runtime.constant.LUnitMember;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
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
