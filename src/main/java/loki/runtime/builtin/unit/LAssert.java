package loki.runtime.builtin.unit;

import loki.execution.Execution;
import loki.runtime.constant.LFunctionalUnit;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.LVoid;
import loki.runtime.datatype.type.LType;
import loki.runtime.util.LAssertionException;
import loki.runtime.util.Nullable;

import java.io.PrintStream;

public class LAssert extends LUnit
{
	public static final LAssert instance = new LAssert();

	private LAssert()
	{
		super(new LType(LFunctionalUnit.ASSERT.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		if (parameters.length < 1) throw new LAssertionException("Actual value is not specified");
		if (parameters.length < 2) throw new LAssertionException("Expected value is not specified");

		LUnit actual = parameters[0];
		LUnit expected = parameters[1];

		if (!actual.equals(expected))
			throw new LAssertionException(
				String.format("%s[%s] does not equal to %s[%s]", actual, actual.getType(), expected, expected.getType())
			);

		getOutputPrintStream()
			.println(String.format("%s[%s] equals to %s[%s]", actual, actual.getType(), expected, expected.getType()));

		return LVoid.instance;
	}

	private static PrintStream getOutputPrintStream()
	{
		return Execution.executor().outputPrintStream();
	}
}
