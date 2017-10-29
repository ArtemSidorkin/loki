package cloki.runtime.datatype;

import cloki.runtime.constant.LDataUnit;

public class LNone extends LUnit
{
	public static final LNone instance = new LNone();

	private LNone()
	{
		super(new LType(LDataUnit.NONE.name));
	}
}
