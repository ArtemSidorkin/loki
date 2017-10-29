package cloki.runtime.builtins.units;

import cloki.runtime.consts.CConstFunctionalUnit;
import cloki.runtime.consts.CConstTypes;
import cloki.runtime.datatypes.*;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.CErrors;
import cloki.runtime.utils.Nullable;

public class CLoop extends CUnit
{
	public static final CLoop instance = new CLoop();

	private CLoop()
	{
		super(new CType(CConstFunctionalUnit.LOOP.name));
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		CUnit cntAsUnt = checkCallParameter(parameters, 0);
		CNumber cntAsNmbr = cntAsUnt.asType(CConstTypes.NUMBER);

		if (cntAsNmbr == null)
		{
			CErrors.printErrorUnitDoesNotBelongToType(cntAsUnt, CConstTypes.NUMBER);
			return CUndefined.instance;
		}

		CUnit actn = checkCallParameter(parameters, 1);

		for (int i = 0; i < cntAsNmbr.getValue(); i++) actn.call(host, null, unitContext);

		return CVoid.instance;
	}
}
