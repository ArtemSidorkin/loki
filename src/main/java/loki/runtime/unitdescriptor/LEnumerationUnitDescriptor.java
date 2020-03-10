package loki.runtime.unitdescriptor;

import loki.runtime.unit.unit.LUnit;

public class LEnumerationUnitDescriptor<UNIT extends LUnit>
{
	private final String name;
	private final UNIT instance;

	public LEnumerationUnitDescriptor(String name, UNIT instance)
	{
		this.name = name;
		this.instance = instance;
	}

	public String getName()
	{
		return name;
	}

	public UNIT getInstance()
	{
		return instance;
	}
}
