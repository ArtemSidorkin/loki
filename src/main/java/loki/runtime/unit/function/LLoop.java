package loki.runtime.unit.function;

import loki.runtime.unit.LVoid;
import loki.runtime.unit.number.LNumber;
import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;

public class LLoop extends LUnit
{
	public static final String TYPE_NAME = "loop";
	public static final LType TYPE = new LType(TYPE_NAME, LLoop.class);

	public static final LLoop INSTANCE = new LLoop();

	private LLoop()
	{
		super(TYPE);
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		LUnit iterationCountAsUnit = checkCallParameter(parameters, 0);
		LNumber iterationCountAsNumber = iterationCountAsUnit.asType(LNumber.TYPE);

		if (iterationCountAsNumber == null)
		{
			LErrors.operandShouldHaveType(iterationCountAsUnit, LNumber.TYPE);

			return null;
		}

		LUnit action = checkCallParameter(parameters, 1);

		for (int i = 0; i < iterationCountAsNumber.getValue(); i++) action.call(host, EMPTY_UNIT_ARRAY);

		return LVoid.INSTANCE;
	}
}