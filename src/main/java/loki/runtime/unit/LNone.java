package loki.runtime.unit;

import loki.runtime.constant.LDataUnit;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LNone extends LUnit
{
	public static final LNone INSTANCE = new LNone();

	private LNone()
	{
		super(new LType(LDataUnit.NONE.name));
	}
}
