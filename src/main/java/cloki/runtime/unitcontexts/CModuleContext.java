package cloki.runtime.unitcontexts;

import cloki.runtime.datatypes.CUnit;

public class CModuleContext extends CUnitContext
{
	public CModuleContext(CUnit self, CUnit host, CUnit[] parameters, CUnitContext parentUnitContext)
	{
		super(self, host, parentUnitContext, parameters, parentUnitContext != null);
	}
}
