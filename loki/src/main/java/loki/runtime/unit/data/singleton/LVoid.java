package loki.runtime.unit.data.singleton;

import loki.runtime.compilerapi.common.VoidGetInstance;
import loki.runtime.error.LErrors;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unit.unit.member.operation.binary.LEqualityUnitBinaryOperation;
import loki.runtime.unit.unit.member.operation.binary.LInequalityUnitBinaryOperation;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LVoid extends LUnit
{
	public static final LInstanceUnitDescriptor<LVoid> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("void", LVoid.class, LVoid::new);

	private LVoid()
	{
		super(DESCRIPTOR.getType());
	}

	@VoidGetInstance
	public static LVoid getInstance()
	{
		return DESCRIPTOR.getInstance();
	}

	@Override
	public LUnit newInstance(LUnit[] parameters)
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
		if (LEqualityUnitBinaryOperation.DESCRIPTOR.getName().equals(memberName))
			return LBoolean.valueOf(this == checkCallParameter(parameters, 0));

		if (LInequalityUnitBinaryOperation.DESCRIPTOR.getName().equals(memberName))
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
		return DESCRIPTOR.getInstance() == object;
	}

	@Override
	public String toString()
	{
		return "void";
	}
}