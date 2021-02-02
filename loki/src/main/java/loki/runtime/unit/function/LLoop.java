package loki.runtime.unit.function;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

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

		double iterationCount =
			getParameter(host, parameters, ITERATION_COUNT_PARAMETER_INDEX, DESCRIPTOR, LNumber.DESCRIPTOR).getValue();

		for (long i = 0; i < iterationCount; i++) action.call(host);

		return LVoid.DESCRIPTOR.getInstance();
	}
}