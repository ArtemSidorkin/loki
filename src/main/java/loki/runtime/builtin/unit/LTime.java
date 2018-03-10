package loki.runtime.builtin.unit;

import loki.runtime.constant.LFunctionalUnit;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.LType;
import loki.runtime.datatype.LUnit;
import loki.runtime.util.Nullable;

public class LTime extends LUnit
{
	public static final LTime instance = new LTime();

	private LTime()
	{
		super(new LType(LFunctionalUnit.TIME.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return new LNumber(System.nanoTime());
	}
}
