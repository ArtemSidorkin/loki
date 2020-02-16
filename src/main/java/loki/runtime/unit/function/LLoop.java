package loki.runtime.unit.function;

import loki.runtime.constant.LTypes;
import loki.runtime.unit.LVoid;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;

public class LLoop extends LUnit
{
	public static final String NAME = "loop";
	public static final LLoop INSTANCE = new LLoop();

	private LLoop()
	{
		super(new LType(NAME));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		LUnit iterationCountAsUnit = checkCallParameter(parameters, 0);
		LNumber iterationCountAsNumber = iterationCountAsUnit.asType(LTypes.NUMBER);

		if (iterationCountAsNumber == null)
		{
			LErrors.unitDoesNotBelongToType(iterationCountAsUnit, LTypes.NUMBER.getFullName());

			return LVoid.INSTANCE;
		}

		LUnit action = checkCallParameter(parameters, 1);

		for (int i = 0; i < iterationCountAsNumber.getValue(); i++) action.call(host, EMPTY_UNIT_ARRAY);

		return LVoid.INSTANCE;
	}
}