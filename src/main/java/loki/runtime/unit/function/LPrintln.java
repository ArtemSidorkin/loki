package loki.runtime.unit.function;

import loki.execution.Execution;
import loki.runtime.unit.LVoid;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LPrintln extends LUnit
{
	public static final String NAME = "println";
	public static final LPrintln INSTANCE = new LPrintln();

	private LPrintln()
	{
		super(new LType(NAME));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		if (parameters.length > 0)
			for (LUnit parameter : parameters) Execution.executor().outputPrintStream().println(parameter);
		else Execution.executor().outputPrintStream().println();

		return LVoid.INSTANCE;
	}
}