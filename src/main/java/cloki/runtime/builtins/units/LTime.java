package cloki.runtime.builtins.units;

import cloki.runtime.constant.LFunctionalUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.number.LNumber;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.utils.Nullable;

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
