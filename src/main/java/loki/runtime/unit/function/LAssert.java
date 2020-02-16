package loki.runtime.unit.function;

import loki.execution.Execution;
import loki.runtime.unit.LVoid;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LAssertionException;

public class LAssert extends LUnit
{
	public static final String NAME = "assert";
	public static final LAssert INSTANCE = new LAssert();

	private LAssert()
	{
		super(new LType(NAME));
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

		return LVoid.INSTANCE;
	}
}