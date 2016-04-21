package cloki.runtime.datatypes;

import cloki.runtime.unitcontexts.CUnitContext;

public class CModule extends CUnit
{
	public CModule(String moduleTypeName, CUnitContext moduleContext)
	{
		super(new CType("[module]" + moduleTypeName), (unit) -> moduleContext);
	}
}
