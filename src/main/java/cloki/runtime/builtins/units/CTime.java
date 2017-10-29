package cloki.runtime.builtins.units;

import cloki.runtime.constant.LFunctionalUnit;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

public class CTime extends LUnit
{
	public static final CTime instance = new CTime();

	private CTime()
	{
		super(new LType(LFunctionalUnit.TIME.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return new LNumber(System.nanoTime());
	}
}
