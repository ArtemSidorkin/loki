package cloki.runtime.builtins.units;

import cloki.runtime.constant.LFunctionalUnit;
import cloki.runtime.constant.LTypes;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.*;
import cloki.runtime.datatype.number.LNumber;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;

public class LLoop extends LUnit
{
	public static final LLoop instance = new LLoop();

	private LLoop()
	{
		super(new LType(LFunctionalUnit.LOOP.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		LUnit countAsUnit = checkCallParameter(parameters, 0);
		LNumber countAsNumber = countAsUnit.asType(LTypes.NUMBER);

		if (countAsNumber == null)
		{
			LErrors.printErrorUnitDoesNotBelongToType(countAsUnit, LTypes.NUMBER);
			return LUndefined.instance;
		}

		LUnit actions = checkCallParameter(parameters, 1);

		for (int i = 0; i < countAsNumber.getValue(); i++) actions.call(host, emptyUnitArray, unitContext);

		return LVoid.instance;
	}
}
