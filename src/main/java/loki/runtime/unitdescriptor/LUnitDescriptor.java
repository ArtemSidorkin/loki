package loki.runtime.unitdescriptor;

import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LUnitDescriptor<UNIT extends LUnit>
{
	private final Class<UNIT> typeClass;
	private final LType type;
	private volatile UNIT unit;

	public LUnitDescriptor(String typeName, Class<UNIT> typeClass)
	{
		this.typeClass = typeClass;
		type = new LType(typeName, typeClass);
	}

	public LType getType()
	{
		return type;
	}

	protected UNIT getUnit()
	{
		if (unit == null) synchronized (this)
		{
			if (unit == null) unit = createUnit(typeClass);
		}

		return unit;
	}

	private UNIT createUnit(Class<UNIT> typeClass)
	{
		try
		{
			Constructor<UNIT> constructor = typeClass.getDeclaredConstructor();
			constructor.setAccessible(true);
			return constructor.newInstance();
		}
		catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e)
		{
			throw new RuntimeException("Unit should have default constructor", e);
		}
	}
}
