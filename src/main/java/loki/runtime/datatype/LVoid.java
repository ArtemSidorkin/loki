package loki.runtime.datatype;

import loki.runtime.constant.LDataUnit;

public class LVoid extends LUnit
{
	public static final LVoid instance = new LVoid();

	private LVoid()
	{
		super(new LType(LDataUnit.VOID.name));
	}
}
