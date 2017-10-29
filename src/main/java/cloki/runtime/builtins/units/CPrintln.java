package cloki.runtime.builtins.units;

import cloki.execution.CExecution;
import cloki.runtime.consts.CConstFunctionalUnit;
import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.datatypes.CVoid;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.Nullable;

import java.io.PrintStream;

public class CPrintln extends CUnit
{
	public static final CPrintln instance = new CPrintln();

	private CPrintln()
	{
		super(new CType(CConstFunctionalUnit.PRINTLN.name));
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		if (parameters.length > 0)
			for (CUnit prmtr : parameters) getOutputPrintStream().println(prmtr);
		else getOutputPrintStream().println();

		return CVoid.instance;
	}

	private static PrintStream getOutputPrintStream()
	{
		return CExecution.executor().instance().outputPrintStream();
	}
}
