package loki.runtime.unit;

import loki.runtime.constant.LTypes;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.Nullable;

public class LObject extends LUnit
{
	public static final LObject PROTOTYPE = new LObject();

	public LObject(@Nullable LUnit[] items)
	{
		super(LTypes.OBJECT);

		_addParents(PROTOTYPE);

		if (items != null)
			for (int i = 0; i < items.length; i += 2) setMember(items[i].toString(), items[i + 1]);
	}

	private LObject()
	{
		super(LTypes.OBJECT_PROTOTYPE);
	}
}
