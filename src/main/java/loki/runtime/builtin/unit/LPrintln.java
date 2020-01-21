package loki.runtime.builtin.unit;

import loki.execution.Execution;
import loki.runtime.constant.LFunctionalUnit;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.LVoid;
import loki.runtime.datatype.type.LType;
import loki.runtime.util.Nullable;

import java.io.PrintStream;

public class LPrintln extends LUnit
{
	public static final LPrintln instance = new LPrintln();

	private LPrintln()
	{
		super(new LType(LFunctionalUnit.PRINTLN.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		if (parameters.length > 0)
			for (LUnit parameter : parameters) getOutputPrintStream().println(parameter);
		else getOutputPrintStream().println();

		return LVoid.instance;
	}

	private static PrintStream getOutputPrintStream()
	{
		return Execution.executor().outputPrintStream();
	}
}
