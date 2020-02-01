package loki.runtime.datatype;

import loki.runtime.datatype.unit.LUnit;
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
