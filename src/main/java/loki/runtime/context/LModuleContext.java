package loki.runtime.context;

import loki.runtime.unit.unit.LUnit;

public class LModuleContext extends LUnitContext
{
	public LModuleContext(LUnit moduleUnit, LUnit host, LUnit[] parameters)
	{
		super(moduleUnit, host, null, parameters);
	}
}
