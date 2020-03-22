package loki.runtime.unit;

import loki.runtime.LType;
import loki.runtime.compilerapi.module.ModuleConstructor;
import loki.runtime.unit.unit.LUnit;

public class LModule extends LUnit
{
	@ModuleConstructor
	public LModule(String moduleTypeName)
	{
		setType(new LType(String.format("module<%s>", moduleTypeName), getClass()));
	}
}
