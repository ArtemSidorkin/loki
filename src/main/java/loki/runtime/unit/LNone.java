package loki.runtime.unit;

import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LNone extends LUnit
{
	public static final String TYPE_NAME = "none";
	public static final LType TYPE = new LType(TYPE_NAME, LNone.class);

	public static final LNone INSTANCE = new LNone();

	private LNone()
	{
		super(TYPE);
	}
}