package loki.runtime.unit;

import loki.runtime.constant.LDataUnit;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;

import java.util.function.Consumer;

public class LVoid extends LUnit
{
	public static final LVoid INSTANCE = new LVoid();

	private LVoid()
	{
		super(new LType(LDataUnit.VOID.name));
	}

	@Override
	public LUnit addParents(LUnit... parents)
	{
		LErrors.printErrorAndExit("Adding parents to \"void\" is not allowed");

		return null;
	}

	@Override
	public LUnit setMember(String memberName, LUnit member)
	{
		LErrors.printErrorAndExit("Setting member of \"void\"  is not allowed");

		return null;
	}

	@Override
	public LUnit newInstance(LUnit[] parameters, Consumer<LUnit> saver)
	{
		LErrors.printErrorAndExit("Instantiating \"void\" is not allowed");

		return null;
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		LErrors.printErrorAndExit("Calling \"void\" is not allowed");

		return null;
	}
}