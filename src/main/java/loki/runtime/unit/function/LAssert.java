package loki.runtime.unit.function;

import loki.execution.Execution;
import loki.runtime.unit.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;
import loki.runtime.util.LAssertionException;

public class LAssert extends LUnit
{
	public static final LInstanceUnitDescriptor<LAssert> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("assert", LAssert.class);

	private LAssert()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		if (parameters.length < 1) throw new LAssertionException("Actual value is not specified");
		if (parameters.length < 2) throw new LAssertionException("Expected value is not specified");

		LUnit actual = parameters[0];
		LUnit expected = parameters[1];

		if (!actual.equals(expected))
			throw new LAssertionException(
				String.format("%s[%s] does not equal to %s[%s]", actual, actual.getType(), expected, expected.getType())
			);

		Execution
			.executor()
			.outputPrintStream()
			.println(String.format("%s[%s] equals to %s[%s]", actual, actual.getType(), expected, expected.getType()));

		return LVoid.DESCRIPTOR.getInstance();
	}
}