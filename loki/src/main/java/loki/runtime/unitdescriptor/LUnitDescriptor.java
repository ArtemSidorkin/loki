package loki.runtime.unitdescriptor;

import loki.runtime.LUnitType;
import loki.runtime.unit.unit.LUnit;

import java.util.function.Supplier;

import static loki.runtime.LUnitType.SELF;

public abstract class LUnitDescriptor<UNIT extends LUnit>
{
	public static LUnitDescriptor SELF_TYPE = new LUnitDescriptor() {};

	private final LUnitType unitType;
	private final Supplier<UNIT> unitFactory;
	private volatile UNIT unit;

	public LUnitDescriptor(String unitName, Class<UNIT> unitTypeClass, Supplier<UNIT> unitFactory)
	{
		this.unitFactory = unitFactory;

		unitType = new LUnitType(unitName, unitTypeClass);
	}

	private LUnitDescriptor()
	{
		unitType = SELF;

		unitFactory = () -> null;
	}

	public String getUnitName()
	{
		return unitType.getName();
	}

	public boolean isUnit(String unitName)
	{
		return unitType.getName().equals(unitName);
	}

	public LUnitType getUnitType()
	{
		return unitType;
	}

	protected UNIT getUnit()
	{
		if (unit == null) synchronized (this)
		{
			if (unit == null) unit = unitFactory.get();
		}

		return unit;
	}
}