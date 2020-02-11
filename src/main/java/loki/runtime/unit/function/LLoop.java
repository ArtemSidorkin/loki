package loki.runtime.unit.function;

import loki.runtime.constant.LFunctionalUnit;
import loki.runtime.constant.LTypes;
import loki.runtime.unit.LUndefined;
import loki.runtime.unit.LVoid;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;

public class LLoop extends LUnit
{
	public static final LLoop instance = new LLoop();

	private LLoop()
	{
		super(new LType(LFunctionalUnit.LOOP.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		LUnit countAsUnit = checkCallParameter(parameters, 0);
		LNumber countAsNumber = countAsUnit.asType(LTypes.NUMBER);

		if (countAsNumber == null)
		{
			LErrors.unitDoesNotBelongToType(countAsUnit, LTypes.NUMBER.getFullName());

			return LUndefined.INSTANCE;
		}

		LUnit actions = checkCallParameter(parameters, 1);

		for (int i = 0; i < countAsNumber.getValue(); i++) actions.call(host, EMPTY_UNIT_ARRAY);

		return LVoid.INSTANCE;
	}
}
