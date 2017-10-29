package cloki.runtime.datatype;

import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

public class LModule extends LUnit
{
	public LModule(String moduleTypeName, @Nullable LUnitContext moduleContext)
	{
		super(new LType("[module] ".concat(moduleTypeName)), moduleContext);
	}
}
