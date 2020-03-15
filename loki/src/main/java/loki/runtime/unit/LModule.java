package loki.runtime.unit;

import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.Compiler;

public class LModule extends LUnit
{
	@Compiler
	public LModule(String moduleTypeName)
	{
		setType(new LType(String.format("module<%s>", moduleTypeName), getClass()));
	}
}
