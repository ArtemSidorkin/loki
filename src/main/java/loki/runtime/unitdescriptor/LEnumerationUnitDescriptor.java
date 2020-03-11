package loki.runtime.unitdescriptor;

import loki.runtime.unit.unit.LUnit;

public class LEnumerationUnitDescriptor<UNIT extends LUnit> extends LUnitDescriptor
{
	private final UNIT instance;

	public LEnumerationUnitDescriptor(String name, UNIT instance)
	{
		super(name);

		this.instance = instance;
	}

	public UNIT getInstance()
	{
		return instance;
	}
}
