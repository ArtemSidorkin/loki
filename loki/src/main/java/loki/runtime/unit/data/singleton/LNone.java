package loki.runtime.unit.data.singleton;

import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LNone extends LUnit
{
	public static final LInstanceDescriptor<LNone> DESCRIPTOR =
		new LInstanceDescriptor<>("none", LNone.class, LNone::new);

	private LNone()
	{
		super(DESCRIPTOR.getUnitType());
	}
}