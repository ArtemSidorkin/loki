package loki.runtime.unitdescriptor;

import loki.runtime.unit.unit.LUnit;

public class LInstanceUnitDescriptor<UNIT extends LUnit> extends LUnitDescriptor<UNIT>
{
	public LInstanceUnitDescriptor(String typeName, Class<UNIT> typeClass)
	{
		super(typeName, typeClass);
	}

	public UNIT getInstance()
	{
		return getUnit();
	}
}
