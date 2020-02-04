package loki.runtime.unit;

import loki.runtime.unit.unit.LUnit;

public class LMap extends LMapPrototype
{
	{
		_addParents(LMapPrototype.instance);
	}

	public LMap(LUnit[] items)
	{
		super(items);
	}
}
