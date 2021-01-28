package loki.runtime.unit.function;

import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

import static java.lang.System.out;

public class LPrintln extends LUnit
{
	public static final LInstanceDescriptor<LPrintln> DESCRIPTOR =
		new LInstanceDescriptor<>("println", LPrintln.class, LPrintln::new);

	private LPrintln()
	{
		super(DESCRIPTOR);
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		if (parameters.length > 0)
			for (LUnit parameter : parameters) out.println(parameter);
		else out.println();

		return LVoid.DESCRIPTOR.getInstance();
	}
}