package loki.runtime.unit.unit.member;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LAddParents extends LMember
{
	public static final LInstanceUnitDescriptor<LAddParents> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("addParents", LAddParents.class, LAddParents::new);

	private LAddParents()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		host._addParents(parameters);

		return host;
	}
}
