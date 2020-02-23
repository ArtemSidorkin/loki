package loki.runtime.unit.function;

import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LTimeInNanoseconds extends LUnit
{
	public static final String TYPE_NAME = "timeInNanoseconds";
	public static final LType TYPE = new LType(TYPE_NAME, LTimeInNanoseconds.class);

	public static final LTimeInNanoseconds INSTANCE = new LTimeInNanoseconds();

	private LTimeInNanoseconds()
	{
		super(TYPE);
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return new LNumber(System.nanoTime());
	}
}