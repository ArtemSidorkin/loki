package loki.runtime.unit.function;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

import static loki.runtime.error.LErrors.methodParameterHasWrongType;

public class LLoop extends LUnit
{
	private static final int ITERATION_COUNT_PARAMETER_INDEX = 0;
	private static final int ACTION_PARAMETER_INDEX = 0;

	public static final LInstanceDescriptor<LLoop> DESCRIPTOR =
		new LInstanceDescriptor<>("loop", LLoop.class, LLoop::new);

	private LLoop()
	{
		super(DESCRIPTOR);
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		LUnit action = getParameter(parameters, ACTION_PARAMETER_INDEX);

		for (long i = 0; i < getIterationCount(host, parameters); i++) action.call(host);

		return LVoid.DESCRIPTOR.getInstance();
	}

	private double getIterationCount(LUnit host, LUnit... parameters)
	{
		return
			getParameter(parameters, ITERATION_COUNT_PARAMETER_INDEX)
				.asType(
					LNumber.DESCRIPTOR, methodParameterHasWrongType(host, DESCRIPTOR, ITERATION_COUNT_PARAMETER_INDEX)
				)
				.getValue();
	}
}