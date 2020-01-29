package loki.runtime.datatype;

import loki.runtime.constant.LDataUnit;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.type.LType;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.util.LErrors;
import loki.runtime.util.Nullable;

import java.util.function.Consumer;

//TODO: add all missing methods
public class LUndefined extends LUnit
{
	public static final LUndefined instance = new LUndefined();

	private LUndefined()
	{
		super(new LType(LDataUnit.UNDEFINED.name));
	}

	@Override
	public LUnit addParent(LUnit parent)
	{
		LErrors.printErrorAndExit("Inheriting from \"undefined\"!");

		return null;
	}

	@Override
	public LUnit getSuperMember(String superMemberName)
	{
		LErrors.printErrorAndExit("Getting supper member from \"undefined\"!");

		return null;
	}

	@Override
	public LUnit getMember(String memberName)
	{
		LErrors.printErrorAndExit("Getting member from \"undefined\"!");

		return null;
	}

	@Override
	public LUnit setMember(String memberName, LUnit member)
	{
		LErrors.printErrorAndExit("Setting member to \"undefined\"!");

		return null;
	}

	@Override
	public LUnit instantiate(LUnit[] parameters, Consumer<LUnit> saver)
	{
		LErrors.printErrorAndExit("Instantiating \"undefined\"!");

		return null;
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		LErrors.printErrorAndExit("Calling \"undefined\"!");

		return null;
	}

	@Override
	public LUnit callMember(String memberName, LUnit[] parameters)
	{
		LErrors.printErrorAndExit("Calling member of \"undefined\"!");

		return null;
	}

	@Nullable
	@Override
	public <T extends LUnit> T asType(LType type)
	{
		LErrors.printErrorAndExit("Calling \"asType\" from \"undefined\"!");

		return null;
	}

	@Override
	public int hashCode()
	{
		LErrors.printErrorAndExit("Calling \"hashCode\" from \"undefined\"!");

		return -1;
	}

	@Override
	public boolean equals(Object object)
	{
		LErrors.printErrorAndExit("Calling \"equals\" from \"undefined\"!");

		return false;
	}

}
