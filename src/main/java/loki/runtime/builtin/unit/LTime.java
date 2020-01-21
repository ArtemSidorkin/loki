package loki.runtime.builtin.unit;

import loki.runtime.constant.LFunctionalUnit;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.type.LType;
import loki.runtime.util.Nullable;

public class LTime extends LUnit
{
	public static final LTime instance = new LTime();

	private LTime()
	{
		super(new LType(LFunctionalUnit.TIME.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		return new LNumber(System.nanoTime());
	}
}
