package loki.runtime.unitdescriptor;

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
}
