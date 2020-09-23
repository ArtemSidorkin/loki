package loki.runtime.unitdescriptor;

import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;

import java.util.function.Supplier;

public class LPrototypeUnitDescriptor<UNIT extends LUnit> extends LUnitDescriptor<UNIT>
{
	private final String prototypeName;
	private final LType prototypeType;

	public LPrototypeUnitDescriptor(String name, String prototypeName, Class<UNIT> typeClass, Supplier<UNIT> creator)
	{
		super(name, typeClass, creator);

		this.prototypeName = prototypeName;

		prototypeType = new LType(prototypeName, typeClass);
	}

	public String getPrototypeName()
	{
		return prototypeName;
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
