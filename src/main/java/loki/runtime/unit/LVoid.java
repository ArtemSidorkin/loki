package loki.runtime.unit;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;

import java.util.function.Consumer;

public class LVoid extends LUnit
{
	public static final String TYPE_NAME = "void";
	public static final LType TYPE = new LType(TYPE_NAME, LVoid.class);

	public static final LVoid INSTANCE = new LVoid();

	private LVoid()
	{
		super(TYPE);
	}

	@Override
	public LUnit newInstance(LUnit[] parameters, Consumer<LUnit> saver)
	{
		LErrors.printErrorAndExit("Instantiating \"void\" is not allowed");

		return null;
	}

	@Override
	public LUnit getMember(String memberName)
	{
		LErrors.printErrorAndExit("Getting member of \"void\"  is not allowed");

		return null;
	}

	@Override
	public LUnit setMember(String memberName, LUnit member)
	{
		LErrors.printErrorAndExit("Setting member of \"void\"  is not allowed");

		return null;
	}

	@Override
	public LUnit getSuperMember(String superMemberName)
	{
		LErrors.printErrorAndExit("Getting super member of \"void\"  is not allowed");

		return null;
	}

	@Override
	public LUnit addParents(LUnit... parents)
	{
		LErrors.printErrorAndExit("Adding parents to \"void\" is not allowed");

		return null;
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		LErrors.printErrorAndExit("Calling \"void\" is not allowed");

		return null;
	}

	@Override
	public LUnit callMember(String memberName, LUnit[] parameters)
	{
		if (LBinaryOperator.EQUALS_EQUALS.symbol.equals(memberName))
			return LBoolean.valueOf(this == checkCallParameter(parameters, 0));

		if (LBinaryOperator.BANG_EQUALS.symbol.equals(memberName))
			return LBoolean.valueOf(this != checkCallParameter(parameters, 0));

		LErrors
			.printErrorAndExit(
				String
					.format(
						"Calling member of \"void\" is not allowed except \"%s\" and \"%s\"",
						LBinaryOperator.EQUALS_EQUALS,
						LBinaryOperator.BANG_EQUALS
					)
			);

		return null;
	}

	@Override
	public int hashCode()
	{
		return 0;
	}

	@Override
	public boolean equals(Object object)
	{
		return INSTANCE == object;
	}

	@Override
	public String toString()
	{
		return "void";
	}
}