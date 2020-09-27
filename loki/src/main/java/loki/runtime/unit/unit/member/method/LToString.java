package loki.runtime.unit.unit.member.method;

import loki.runtime.unit.member.LUnitMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LToString extends LUnitMember<LToString>
{
	public static final LInstanceDescriptor<LToString> DESCRIPTOR =
		new LInstanceDescriptor<>("toString", LToString.class, LToString::new);

	private LToString()
	{
		super(DESCRIPTOR);
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return host._toString();
	}
}
