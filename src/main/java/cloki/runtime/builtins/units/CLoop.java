package cloki.runtime.builtins.units;

import cloki.runtime.constant.LFunctionalUnit;
import cloki.runtime.constant.LTypes;
import cloki.runtime.datatype.*;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;

public class CLoop extends LUnit
{
	public static final CLoop instance = new CLoop();

	private CLoop()
	{
		super(new LType(LFunctionalUnit.LOOP.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		LUnit cntAsUnt = checkCallParameter(parameters, 0);
		LNumber cntAsNmbr = cntAsUnt.asType(LTypes.NUMBER);

		if (cntAsNmbr == null)
		{
			LErrors.printErrorUnitDoesNotBelongToType(cntAsUnt, LTypes.NUMBER);
			return LUndefined.instance;
		}

		LUnit actn = checkCallParameter(parameters, 1);

		for (int i = 0; i < cntAsNmbr.getValue(); i++) actn.call(host, null, unitContext);

		return LVoid.instance;
	}
}
