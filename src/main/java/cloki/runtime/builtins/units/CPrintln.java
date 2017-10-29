package cloki.runtime.builtins.units;

import cloki.execution.CExecution;
import cloki.runtime.constant.LFunctionalUnit;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.datatype.LVoid;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

import java.io.PrintStream;

public class CPrintln extends LUnit
{
	public static final CPrintln instance = new CPrintln();

	private CPrintln()
	{
		super(new LType(LFunctionalUnit.PRINTLN.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		if (parameters.length > 0)
			for (LUnit prmtr : parameters) getOutputPrintStream().println(prmtr);
		else getOutputPrintStream().println();

		return LVoid.instance;
	}

	private static PrintStream getOutputPrintStream()
	{
		return CExecution.executor().instance().outputPrintStream();
	}
}
