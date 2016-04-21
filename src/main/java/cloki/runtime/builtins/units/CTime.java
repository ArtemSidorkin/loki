package cloki.runtime.builtins.units;

import cloki.runtime.consts.CConstFunctionalUnit;
import cloki.runtime.datatypes.CNumber;
import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.Nullable;

public class CTime extends CUnit
{
	public static final CTime instance = new CTime();

	private CTime()
	{
		super(new CType(CConstFunctionalUnit.TIME.name));
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		return new CNumber(System.nanoTime());
	}
}
