package cloki.runtime.datatype;

import cloki.runtime.consts.LConstDataUnit;

public class LVoid extends LUnit
{
	public static final LVoid instance = new LVoid();

	private LVoid()
	{
		super(new LType(LConstDataUnit.VOID.name));
	}
}
