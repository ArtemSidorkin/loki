package loki.runtime.unit.data.singleton;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;
import loki.runtime.util.Compiler;
import loki.runtime.util.LErrors;

import java.util.function.Consumer;

public class LVoid extends LUnit
{
	public static final LInstanceUnitDescriptor<LVoid> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("void", LVoid.class, LVoid::new);

	private LVoid()
	{
		super(DESCRIPTOR.getType());
	}

	@Compiler
	public static LVoid getInstance()
	{
		return DESCRIPTOR.getInstance();
	}

	@Override
	public LUnit newInstance(LUnit[] parameters, Consumer<LUnit> saver)
	{
		LErrors.actionIsNotAllowedForUnit("instantiating", this);

		return null;
	}

	@Override
	public LUnit getMember(String memberName)
	{
		LErrors.actionIsNotAllowedForUnit("getting members", this);

		return null;
	}

	@Override
	public LUnit setMember(String memberName, LUnit member)
	{
		LErrors.actionIsNotAllowedForUnit("setting members", this);

		return null;
	}

	@Override
	public LUnit getSuperMember(String superMemberName)
	{
		LErrors.actionIsNotAllowedForUnit("getting super members", this);

		return null;
	}

	@Override
	public LUnit addParents(LUnit... parents)
	{
		LErrors.actionIsNotAllowedForUnit("adding parents", this);

		return null;
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		LErrors.actionIsNotAllowedForUnit("calling", this);

		return null;
	}

	@Override
	public LUnit callMember(String memberName, LUnit[] parameters)
	{
		if (LBinaryOperator.EQUALS_EQUALS.symbol.equals(memberName))
			return LBoolean.valueOf(this == checkCallParameter(parameters, 0));

		if (LBinaryOperator.BANG_EQUALS.symbol.equals(memberName))
			return LBoolean.valueOf(this != checkCallParameter(parameters, 0));

		LErrors.actionIsNotAllowedForUnit(String.format("calling member \"%s\"", memberName), this);

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
		if (object == null) return false;

		return DESCRIPTOR.getInstance() == object;
	}

	@Override
	public String toString()
	{
		return "void";
	}
}