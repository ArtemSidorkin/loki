package loki.runtime.unit.function;

import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LPrintln extends LUnit
{
	public static final LInstanceUnitDescriptor<LPrintln> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("println", LPrintln.class, LPrintln::new);

	private LPrintln()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		if (parameters.length > 0)
			for (LUnit parameter : parameters) System.out.println(parameter);
		else System.out.println();

		return LVoid.DESCRIPTOR.getInstance();
	}
}