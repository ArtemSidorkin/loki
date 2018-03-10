package loki.runtime.datatype;

import loki.runtime.constant.LDataUnit;

public class LNone extends LUnit
{
	public static final LNone instance = new LNone();

	private LNone()
	{
		super(new LType(LDataUnit.NONE.name));
	}
}
