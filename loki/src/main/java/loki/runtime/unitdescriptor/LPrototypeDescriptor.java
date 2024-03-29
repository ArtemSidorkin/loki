package loki.runtime.unitdescriptor;

import loki.runtime.LUnitType;
import loki.runtime.unit.unit.LUnit;

import java.util.function.Supplier;

public class LPrototypeDescriptor<UNIT extends LUnit> extends LUnitDescriptor<UNIT>
{
	private final String prototypeName;
	private final LUnitType prototypeType;

	public LPrototypeDescriptor(
		String unitName, String prototypeName, Class<UNIT> prototypeTypeClass, Supplier<UNIT> prototypeFactory
	)
	{
		super(unitName, prototypeTypeClass, prototypeFactory);

		this.prototypeName = prototypeName;

		prototypeType = new LUnitType(prototypeName, prototypeTypeClass);
	}

	public String getPrototypeName()
	{
		return prototypeName;
	}

	public LUnitType getPrototypeType()
	{
		return prototypeType;
	}

	public UNIT getPrototype()
	{
		return getUnit();
	}
}
