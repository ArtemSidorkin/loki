package loki.runtime.unit.function;

import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LTest extends LUnit
{
	public static final LInstanceUnitDescriptor<LTest> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("test", LTest.class, LTest::new);

	private static final List<LUnit> values = Collections.synchronizedList(new ArrayList<>());

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		values.add(checkCallParameter(parameters, 0));
		return LVoid.DESCRIPTOR.getInstance();
	}

	public static List<LUnit> getValues()
	{
		return values;
	}

	public static void clear()
	{
		values.clear();
	}
}
