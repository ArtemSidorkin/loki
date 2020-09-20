package loki.runtime.unit.data.singleton;

import loki.runtime.compilerapi.common.VoidGetInstance;
import loki.runtime.error.LErrors;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unit.unit.member.LAddParents;
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

	public static boolean hasInstance(LUnit unit)
	{
		return unit == DESCRIPTOR.getInstance();
	}

	@Override
	public LUnit newInstance(LUnit[] parameters)
	{
		LErrors.methodIsNotAllowedForUnit(this, "newInstance");

		return null;
	}

	@Override
	public LUnit getMember(String memberName)
	{
		LErrors.methodIsNotAllowedForUnit(this, "getMember");

		return null;
	}

	@Override
	public LUnit setMember(String memberName, LUnit member)
	{
		LErrors.methodIsNotAllowedForUnit(this, "setMember");

		return null;
	}

	@Override
	public LUnit getSuperMember(String superMemberName)
	{
		LErrors.methodIsNotAllowedForUnit(this, "getSuperMember");

		return null;
	}

	@Override
	public LUnit addParents(LUnit... parents)
	{
		LErrors.methodIsNotAllowedForUnit(this, LAddParents.DESCRIPTOR);

		return null;
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		LErrors.methodIsNotAllowedForUnit(this, "call");

		return null;
	}

	@Override
	public LUnit callMember(String memberName, LUnit... parameters)
	{
		if (LEqualityUnitBinaryOperation.DESCRIPTOR.getName().equals(memberName))
			return LBoolean.valueOf(this == getParameter(parameters, 0));

		if (LInequalityUnitBinaryOperation.DESCRIPTOR.getName().equals(memberName))
			return LBoolean.valueOf(this != getParameter(parameters, 0));

		LErrors.methodIsNotAllowedForUnit(this, "callMember");

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
		return DESCRIPTOR.getName();
	}
}