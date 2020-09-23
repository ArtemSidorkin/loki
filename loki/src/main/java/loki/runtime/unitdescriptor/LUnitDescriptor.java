package loki.runtime.unitdescriptor;

import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;

import java.util.Objects;
import java.util.function.Supplier;

public abstract class LUnitDescriptor<UNIT extends LUnit>
{
	private final String name;
	private final LType type;
	private final Supplier<UNIT> creator;
	private volatile UNIT unit;

	public LUnitDescriptor(String name, Class<UNIT> typeClass, Supplier<UNIT> creator)
	{
		this.name = name;

		this.creator = creator;

		type = new LType(name, typeClass);
	}

	public String getName()
	{
		return name;
	}

	public boolean hasName(String name)
	{
		return Objects.equals(this.name, name);
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
