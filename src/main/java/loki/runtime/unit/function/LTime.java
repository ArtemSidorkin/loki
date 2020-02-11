package loki.runtime.unit.function;

import loki.runtime.constant.LFunctionalUnit;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LTime extends LUnit
{
	public static final LTime instance = new LTime();

	private LTime()
	{
		super(new LType(LFunctionalUnit.TIME.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return new LNumber(System.nanoTime());
	}
}
