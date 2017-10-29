package cloki.runtime.datatype;

import cloki.runtime.consts.LConstDataUnit;

public class LNone extends LUnit
{
	public static final LNone instance = new LNone();

	private LNone()
	{
		super(new LType(LConstDataUnit.NONE.name));
	}
}
