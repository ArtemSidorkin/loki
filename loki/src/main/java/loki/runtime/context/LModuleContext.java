package loki.runtime.context;

import loki.runtime.marker.compilerapi.modulecontext.ModuleContextConstructor;
import loki.runtime.unit.unit.LUnit;

public class LModuleContext extends LUnitContext
{
	@ModuleContextConstructor
	public LModuleContext(LUnit moduleUnit, LUnit host, LUnit[] parameters)
	{
		super(moduleUnit, host, parameters);
	}
}
