package loki.runtime.datatype;

import loki.runtime.datatype.unit.LUnit;

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
