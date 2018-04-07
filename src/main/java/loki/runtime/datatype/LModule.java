package loki.runtime.datatype;

import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.type.LType;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.util.Nullable;

public class LModule extends LUnit
{
	public LModule(String moduleTypeName, @Nullable LUnitContext moduleContext)
	{
		super(new LType("[module] ".concat(moduleTypeName)), moduleContext);
	}
}
