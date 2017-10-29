package cloki.runtime.builtins.units;

import cloki.execution.Execution;
import cloki.runtime.constant.LFunctionalUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.datatype.LVoid;
import cloki.runtime.utils.Nullable;

import java.io.PrintStream;

public class LPrintln extends LUnit
{
	public static final LPrintln instance = new LPrintln();

	private LPrintln()
	{
		super(new LType(LFunctionalUnit.PRINTLN.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		if (parameters.length > 0)
			for (LUnit parameter : parameters) getOutputPrintStream().println(parameter);
		else getOutputPrintStream().println();

		return LVoid.instance;
	}

	private static PrintStream getOutputPrintStream()
	{
		return Execution.executor().instance().outputPrintStream();
	}
}
