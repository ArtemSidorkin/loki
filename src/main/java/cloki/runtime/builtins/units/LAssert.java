package cloki.runtime.builtins.units;

import cloki.execution.Execution;
import cloki.runtime.constant.LFunctionalUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.*;
import cloki.runtime.utils.LAssertionException;
import cloki.runtime.utils.Nullable;

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
