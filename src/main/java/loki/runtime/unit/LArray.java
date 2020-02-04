package loki.runtime.unit;

import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.Nullable;

public class LArray extends LArrayPrototype
{
	{
		_addParents(LArrayPrototype.instance);
	}

	public LArray(@Nullable LUnit[] items)
	{
		super(items);
	}
}
