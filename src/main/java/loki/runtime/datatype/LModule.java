package loki.runtime.datatype;

import loki.runtime.context.LUnitContext;
import loki.runtime.utils.Nullable;

public class LModule extends LUnit
{
	public LModule(String moduleTypeName, @Nullable LUnitContext moduleContext)
	{
		super(new LType("[module] ".concat(moduleTypeName)), moduleContext);
	}
}
