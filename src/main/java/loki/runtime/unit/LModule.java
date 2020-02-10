package loki.runtime.unit;

import loki.runtime.context.LUnitContext;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.Nullable;

public class LModule extends LUnit
{
	public LModule(String moduleTypeName, @Nullable LUnitContext moduleContext)
	{
		super(new LType(String.format("module(%s)", moduleTypeName)), moduleContext);
	}
}
