package loki.runtime.unit.function;

import loki.execution.Execution;
import loki.runtime.constant.LFunctionalUnit;
import loki.runtime.unit.LVoid;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

import java.io.PrintStream;

public class LPrintln extends LUnit
{
	public static final LPrintln instance = new LPrintln();

	private LPrintln()
	{
		super(new LType(LFunctionalUnit.PRINTLN.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		if (parameters.length > 0)
			for (LUnit parameter : parameters) getOutputPrintStream().println(parameter);
		else getOutputPrintStream().println();

		return LVoid.INSTANCE;
	}

	private static PrintStream getOutputPrintStream()
	{
		return Execution.executor().outputPrintStream();
	}
}
