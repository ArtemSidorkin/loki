package loki.runtime.unit.unit.member.method;

import loki.runtime.unit.member.LUnitMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LHashCode extends LUnitMember<LHashCode>
{
	public static final LInstanceDescriptor<LHashCode> DESCRIPTOR =
		new LInstanceDescriptor<>("hashCode", LHashCode.class, LHashCode::new);

	private LHashCode()
	{
		super(DESCRIPTOR);
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return host._hashCode();
	}
}
