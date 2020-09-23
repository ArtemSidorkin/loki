package loki.runtime.unit.data;

import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LPrototypeUnitDescriptor;
import loki.runtime.util.Compiler;
import loki.runtime.util.Prototype;

public class LObject extends LUnit
{
	public static final LPrototypeUnitDescriptor<LObject> DESCRIPTOR =
		new LPrototypeUnitDescriptor<>("Object", "ObjectPrototype", LObject.class, LObject::new);

	@Compiler
	public LObject(LUnit[] items)
	{
		super(DESCRIPTOR.getType());

		_addParents(DESCRIPTOR.getPrototype());

		for (int i = 0; i < items.length; i += 2) setMember(items[i].toString(), items[i + 1]);
	}

	@Prototype
	private LObject()
	{
		super(DESCRIPTOR.getPrototypeType());
	}
}
