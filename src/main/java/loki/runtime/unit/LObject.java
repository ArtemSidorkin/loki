package loki.runtime.unit;

import loki.runtime.unit.unit.LUnit;

public class LObject extends LObjectPrototype
{
	{
		_addParents(LObjectPrototype.instance);
	}

	public LObject(LUnit[] items)
	{
		super(items);
	}
}
