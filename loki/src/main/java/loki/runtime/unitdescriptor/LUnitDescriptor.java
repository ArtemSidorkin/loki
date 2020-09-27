package loki.runtime.unitdescriptor;

import loki.runtime.LUnitType;
import loki.runtime.unit.unit.LUnit;

import java.util.Objects;
import java.util.function.Supplier;

public abstract class LUnitDescriptor<UNIT extends LUnit>
{
	private final LUnitType unitType;
	private final Supplier<UNIT> unitCreator;
	private volatile UNIT unit;

	public LUnitDescriptor(String unitName, Class<UNIT> unitTypeClass, Supplier<UNIT> unitCreator)
	{
		this.unitCreator = unitCreator;

		unitType = new LUnitType(unitName, unitTypeClass);
	}

	public String getUnitName()
	{
		return unitType.getName();
	}

	public boolean hasUnitName(String name)
	{
		return Objects.equals(unitType.getName(), name);
	}

	public LUnitType getUnitType()
	{
		return unitType;
	}

	protected UNIT getUnit()
	{
		if (unit == null) synchronized (this)
		{
			if (unit == null) unit = unitCreator.get();
		}

		return unit;
	}
}
