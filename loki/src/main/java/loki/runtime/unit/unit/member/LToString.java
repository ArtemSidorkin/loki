package loki.runtime.unit.unit.member;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LToString extends LMember
{
	public static final LInstanceUnitDescriptor<LToString> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("toString", LToString.class, LToString::new);

	private LToString()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return host._toString();
	}
}
