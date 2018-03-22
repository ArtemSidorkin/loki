package loki.runtime.datatype;

import loki.runtime.constant.LDataUnit;
import loki.runtime.datatype.type.LType;

public class LNone extends LUnit
{
	public static final LNone instance = new LNone();

	private LNone()
	{
		super(new LType(LDataUnit.NONE.name));
	}
}
