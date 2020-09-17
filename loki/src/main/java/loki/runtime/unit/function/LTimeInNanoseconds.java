package loki.runtime.unit.function;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LTimeInNanoseconds extends LUnit
{
	public static final LInstanceUnitDescriptor<LTimeInNanoseconds> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("timeInNanoseconds", LTimeInNanoseconds.class, LTimeInNanoseconds::new);

	private LTimeInNanoseconds()
	{
		super(LTimeInNanoseconds.DESCRIPTOR.getType());
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return new LNumber(System.nanoTime());
	}
}