package loki.runtime.datatype;

import loki.runtime.constant.LTypes;
import loki.runtime.datatype.unit.LUnit;

public class LObjectPrototype extends LUnit
{
	public static final LObjectPrototype instance = new LObjectPrototype();

	public LObjectPrototype(LUnit[] items)
	{
		super(LTypes.OBJECT);

		if (items != null)
			for (int i = 0; i < items.length; i += 2) setMember(items[i].toString(), items[i + 1]);
	}

	private LObjectPrototype()
	{
		this(null);
	}
}
