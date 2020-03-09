package loki.runtime.unit.data;

import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LDataUnitDescriptor;

public class LObject extends LUnit
{
	public static final LDataUnitDescriptor<LObject> DESCRIPTOR =
		new LDataUnitDescriptor<>("Object", "ObjectPrototype", LObject.class);

	public LObject(LUnit[] items)
	{
		super(DESCRIPTOR.getType());

		_addParents(DESCRIPTOR.getPrototype());

		for (int i = 0; i < items.length; i += 2) setMember(items[i].toString(), items[i + 1]);
	}

	private LObject()
	{
		super(DESCRIPTOR.getPrototypeType());
	}
}
