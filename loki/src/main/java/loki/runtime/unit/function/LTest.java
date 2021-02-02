package loki.runtime.unit.function;

import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.synchronizedList;

public class LTest extends LUnit
{
	private static final int VALUE_PARAMETER_INDEX = 0;

	public static final LInstanceDescriptor<LTest> DESCRIPTOR =
		new LInstanceDescriptor<>("test", LTest.class, LTest::new);

	private static final List<LUnit> values = synchronizedList(new ArrayList<>());

	private LTest()
	{
		super(DESCRIPTOR);
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		values.add(getParameter(parameters, VALUE_PARAMETER_INDEX));

		return LVoid.getInstance();
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
