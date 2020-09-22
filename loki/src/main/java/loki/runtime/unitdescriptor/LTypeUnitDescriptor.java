package loki.runtime.unitdescriptor;

import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;

import java.util.function.Supplier;

public abstract class LTypeUnitDescriptor<UNIT extends LUnit> extends LUnitDescriptor
{
	private final LType type;
	private final Supplier<UNIT> creator;
	private volatile UNIT unit;

	public LTypeUnitDescriptor(String name, Class<UNIT> typeClass, Supplier<UNIT> creator)
	{
		super(name);

		this.creator = creator;

		type = new LType(name, typeClass);
	}

	public LType getType()
	{
		return type;
	}

	protected UNIT getUnit()
	{
		if (unit == null) synchronized (this)
		{
			if (unit == null) unit = creator.get();
		}

		return unit;
	}
}
