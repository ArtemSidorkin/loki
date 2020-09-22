package loki.runtime.unit.data.singleton;

import loki.runtime.compilerapi.common.VoidGetInstance;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unit.unit.member.LAddParents;
import loki.runtime.unit.unit.member.LHashCode;
import loki.runtime.unit.unit.member.operation.binary.LEqualityUnitBinaryOperation;
import loki.runtime.unit.unit.member.operation.binary.LInequalityUnitBinaryOperation;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

import static loki.runtime.error.LErrors.methodIsNotAllowedForUnit;

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
		return methodIsNotAllowedForUnit(this, "newInstance");
	}

	@Override
	public LUnit getMember(String memberName)
	{
		return methodIsNotAllowedForUnit(this, "getMember");
	}

	@Override
	public LUnit setMember(String memberName, LUnit member)
	{
		return methodIsNotAllowedForUnit(this, "setMember");
	}

	@Override
	public LUnit getSuperMember(String superMemberName)
	{
		return methodIsNotAllowedForUnit(this, "getSuperMember");
	}

	@Override
	public LUnit addParents(LUnit... parents)
	{
		return methodIsNotAllowedForUnit(this, LAddParents.DESCRIPTOR);
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return methodIsNotAllowedForUnit(this, "call");
	}

	@Override
	public LUnit callMember(String memberName, LUnit... parameters)
	{
		if (LEqualityUnitBinaryOperation.DESCRIPTOR.hasName(memberName))
			return LBoolean.valueOf(hasInstance(getParameter(parameters, 0)));

		if (LInequalityUnitBinaryOperation.DESCRIPTOR.hasName(memberName))
			return LBoolean.valueOf(!hasInstance(getParameter(parameters, 0)));

		if (LHashCode.DESCRIPTOR.hasName(memberName)) return new LNumber(hashCode());

		return methodIsNotAllowedForUnit(this, "callMember");
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