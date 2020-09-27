package loki.runtime.unit.data;

import loki.runtime.marker.Compiler;
import loki.runtime.marker.Prototype;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LPrototypeDescriptor;

public class LObject extends LUnit
{
	public static final LPrototypeDescriptor<LObject> DESCRIPTOR =
		new LPrototypeDescriptor<>("Object", "ObjectPrototype", LObject.class, LObject::new);

	@Compiler
	public LObject(LUnit[] items)
	{
		super(DESCRIPTOR.getUnitType());

		_addParents(DESCRIPTOR.getPrototype());

		for (int i = 0; i < items.length; i += 2) setMember(items[i].toString(), items[i + 1]);
	}

	@Prototype
	private LObject()
	{
		super(DESCRIPTOR.getPrototypeType());
	}
}
