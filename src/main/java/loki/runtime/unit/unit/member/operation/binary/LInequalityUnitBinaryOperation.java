package loki.runtime.unit.unit.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LInequalityUnitBinaryOperation extends LUnitBinaryOperation
{
	public static final LInstanceUnitDescriptor<LInequalityUnitBinaryOperation> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("!=", LInequalityUnitBinaryOperation.class);

	private LInequalityUnitBinaryOperation()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		return LBoolean.valueOf(leftOperand != rightOperand);
	}
}
