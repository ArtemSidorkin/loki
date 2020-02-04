package loki.runtime.context;

import loki.runtime.unit.unit.LUnit;

public class LModuleContext extends LUnitContext
{
	public LModuleContext(LUnit self, LUnit host, LUnit[] parameters, LUnitContext parentUnitContext)
	{
		super(self, host, parentUnitContext, parameters, parentUnitContext != null);
	}
}
