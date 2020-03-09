package loki.runtime.unitdescriptor;

import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;

public class LDataUnitDescriptor<UNIT extends LUnit> extends LUnitDescriptor<UNIT>
{
	private final LType prototypeType;

	public LDataUnitDescriptor(String typeName, String prototypeName, Class<UNIT> typeClass)
	{
		super(typeName, typeClass);

		prototypeType = new LType(prototypeName, typeClass);
	}

	public LType getPrototypeType()
	{
		return prototypeType;
	}

	public UNIT getPrototype()
	{
		return getUnit();
	}
}
