package loki.runtime.builtin.unit;

import loki.runtime.constant.LFunctionalUnit;
import loki.runtime.constant.LTypes;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.LVoid;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.type.LType;
import loki.runtime.util.LErrors;
import loki.runtime.util.Nullable;

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

		for (int i = 0; i < countAsNumber.value; i++) actions.call(host, EMPTY_UNIT_ARRAY, unitContext);

		return LVoid.instance;
	}
}
