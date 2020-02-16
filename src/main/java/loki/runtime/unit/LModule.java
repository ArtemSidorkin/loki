package loki.runtime.unit;

import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LModule extends LUnit
{
	public LModule(String moduleTypeName)
	{
		super(new LType(String.format("module(%s)", moduleTypeName)));
	}
}
