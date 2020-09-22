package loki.runtime.unitdescriptor;

import java.util.Objects;

public abstract class LUnitDescriptor
{
	private final String name;

	public LUnitDescriptor(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public boolean hasName(String name)
	{
		return Objects.equals(this.name, name);
	}
}
