package loki.runtime.unit.unit.member;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LEquals extends LMember
{
	public static final LInstanceUnitDescriptor<LEquals> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("equals", LEquals.class, LEquals::new);

	public static final int INDEX_OF_OBJECT_IN_PARAMETERS = 0;

	private LEquals()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	public LBoolean call(LUnit host, LUnit... parameters)
	{
		return host._equals(getParameter(parameters, INDEX_OF_OBJECT_IN_PARAMETERS));
	}
}
