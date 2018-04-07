package loki.runtime.datatype;

import loki.runtime.datatype.unit.LUnit;

public class LObject extends LObjectPrototype
{
	{
		addParent(LObjectPrototype.instance);
	}

	public LObject(LUnit[] items)
	{
		super(items);
	}
}
