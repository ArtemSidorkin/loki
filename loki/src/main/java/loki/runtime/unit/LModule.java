package loki.runtime.unit;

import loki.runtime.LUnitType;
import loki.runtime.marker.compilerapi.module.ModuleConstructor;
import loki.runtime.unit.unit.LUnit;

public class LModule extends LUnit
{
	@ModuleConstructor
	public LModule(String name)
	{
		setType(new LUnitType(String.format("[%s]", name), getClass()));
	}
}
