package cloki.runtime.datatype;

import cloki.runtime.constant.LDataUnit;

public class LVoid extends LUnit
{
	public static final LVoid instance = new LVoid();

	private LVoid()
	{
		super(new LType(LDataUnit.VOID.name));
	}
}
