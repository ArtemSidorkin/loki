package loki.runtime.unit.unit.member;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LNew extends LMember
{
	public static final LInstanceUnitDescriptor<LNew> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("new", LNew.class, LNew::new);

	private LNew()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return host.newInstance(parameters, null);
	}
}
