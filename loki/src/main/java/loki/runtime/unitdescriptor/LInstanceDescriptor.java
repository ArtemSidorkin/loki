package loki.runtime.unitdescriptor;

import loki.runtime.unit.unit.LUnit;

import java.util.function.Supplier;

public class LInstanceDescriptor<UNIT extends LUnit> extends LUnitDescriptor<UNIT>
{
	public LInstanceDescriptor(String instanceName, Class<UNIT> instanceTypeClass, Supplier<UNIT> instanceFactory)
	{
		super(instanceName, instanceTypeClass, instanceFactory);
	}

	public UNIT getInstance()
	{
		return getUnit();
	}
}
