package loki.runtime.unit;

import loki.runtime.constant.LDataUnit;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LVoid extends LUnit
{
	public static final LVoid instance = new LVoid();

	private LVoid()
	{
		super(new LType(LDataUnit.VOID.name));
	}
}
