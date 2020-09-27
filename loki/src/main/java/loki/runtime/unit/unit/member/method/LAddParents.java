package loki.runtime.unit.unit.member.method;

import loki.runtime.unit.member.LUnitMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LAddParents extends LUnitMember<LAddParents>
{
	public static final LInstanceDescriptor<LAddParents> DESCRIPTOR =
		new LInstanceDescriptor<>("addParents", LAddParents.class, LAddParents::new);

	private LAddParents()
	{
		super(DESCRIPTOR);
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		host._addParents(parameters);

		return host;
	}
}
