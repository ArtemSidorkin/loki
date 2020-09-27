package loki.runtime.unit.function;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LTimeInNanoseconds extends LUnit
{
	public static final LInstanceDescriptor<LTimeInNanoseconds> DESCRIPTOR =
		new LInstanceDescriptor<>("timeInNanoseconds", LTimeInNanoseconds.class, LTimeInNanoseconds::new);

	private LTimeInNanoseconds()
	{
		super(DESCRIPTOR);
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return new LNumber(System.nanoTime());
	}
}