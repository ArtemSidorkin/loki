package loki.runtime.unit.unit.member;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LHashCode extends LMember
{
	public static final LInstanceUnitDescriptor<LHashCode> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("hashCode", LHashCode.class);

	private LHashCode()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return host._hashCode();
	}
}
