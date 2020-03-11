package loki.runtime.context;

import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.Compiler;

public class LModuleContext extends LUnitContext
{
	@Compiler
	public LModuleContext(LUnit moduleUnit, LUnit host, LUnit[] parameters)
	{
		super(moduleUnit, host, parameters);
	}
}
