package loki.runtime.unitdescriptor;

import loki.runtime.unit.unit.LUnit;

import java.util.function.Supplier;

public class LInstanceUnitDescriptor<UNIT extends LUnit> extends LTypeUnitDescriptor<UNIT>
{
	public LInstanceUnitDescriptor(String name, Class<UNIT> typeClass, Supplier<UNIT> creator)
	{
		super(name, typeClass, creator);
	}

	public UNIT getInstance()
	{
		return getUnit();
	}
}
