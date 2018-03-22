package loki.runtime.datatype;

import loki.runtime.constant.LDataUnit;
import loki.runtime.datatype.type.LType;

public class LVoid extends LUnit
{
	public static final LVoid instance = new LVoid();

	private LVoid()
	{
		super(new LType(LDataUnit.VOID.name));
	}
}
