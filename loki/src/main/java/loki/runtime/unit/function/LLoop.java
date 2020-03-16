package loki.runtime.unit.function;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;
import loki.runtime.error.LErrors;

public class LLoop extends LUnit
{
	public static final LInstanceUnitDescriptor<LLoop> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("loop", LLoop.class, LLoop::new);

	private LLoop()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		LUnit iterationCountAsUnit = checkCallParameter(parameters, 0);
		LNumber iterationCountAsNumber = iterationCountAsUnit.asType(LNumber.DESCRIPTOR.getType());

		if (iterationCountAsNumber == null)
		{
			LErrors.operandShouldHaveType(iterationCountAsUnit, LNumber.DESCRIPTOR.getType());

			return null;
		}

		LUnit action = checkCallParameter(parameters, 1);

		for (int i = 0; i < iterationCountAsNumber.getValue(); i++) action.call(host, EMPTY_UNIT_ARRAY);

		return LVoid.DESCRIPTOR.getInstance();
	}
}