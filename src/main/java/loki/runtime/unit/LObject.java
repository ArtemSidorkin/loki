package loki.runtime.unit;

import loki.runtime.constant.LTypes;
import loki.runtime.unit.unit.LUnit;

public class LObject extends LUnit
{
	public static final String PROTOTYPE_NAME = "ObjectPrototype";
	public static final LObject PROTOTYPE = new LObject();

	public LObject(LUnit[] items)
	{
		super(LTypes.OBJECT);

		_addParents(PROTOTYPE);

		for (int i = 0; i < items.length; i += 2) setMember(items[i].toString(), items[i + 1]);
	}

	private LObject()
	{
		super(LTypes.OBJECT_PROTOTYPE);
	}
}
