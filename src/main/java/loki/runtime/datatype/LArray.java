package loki.runtime.datatype;

import loki.runtime.util.Nullable;

public class LArray extends LArrayPrototype
{
	{
		addParent(LArrayPrototype.instance);
	}

	public LArray(@Nullable LUnit[] items)
	{
		super(items);
	}
}
