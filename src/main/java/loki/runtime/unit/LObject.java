package loki.runtime.unit;

import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;

public class LObject extends LUnit
{
	public static final String TYPE_NAME = "Object";
	public static final LType TYPE = new LType(TYPE_NAME, LObject.class);

	public static final String PROTOTYPE_NAME = "ObjectPrototype";
	public static final LType PROTO_TYPE = new LType(PROTOTYPE_NAME, LObject.class);
	public static final LObject PROTOTYPE = new LObject();

	public LObject(LUnit[] items)
	{
		super(TYPE);

		_addParents(PROTOTYPE);

		for (int i = 0; i < items.length; i += 2) setMember(items[i].toString(), items[i + 1]);
	}

	private LObject()
	{
		super(PROTO_TYPE);
	}
}
