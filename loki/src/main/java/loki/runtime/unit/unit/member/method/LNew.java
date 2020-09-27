package loki.runtime.unit.unit.member.method;

import loki.runtime.unit.member.LUnitMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LNew extends LUnitMember<LNew>
{
	public static final LInstanceDescriptor<LNew> DESCRIPTOR =
		new LInstanceDescriptor<>("new", LNew.class, LNew::new);

	private LNew()
	{
		super(DESCRIPTOR);
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return host.newInstance(parameters);
	}
}
