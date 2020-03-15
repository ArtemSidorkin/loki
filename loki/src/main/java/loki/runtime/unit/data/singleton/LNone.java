package loki.runtime.unit.data.singleton;

import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LNone extends LUnit
{
	public static final LInstanceUnitDescriptor<LNone> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("none", LNone.class, LNone::new);

	private LNone()
	{
		super(DESCRIPTOR.getType());
	}
}