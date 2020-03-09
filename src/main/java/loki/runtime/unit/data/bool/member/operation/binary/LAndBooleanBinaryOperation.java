package loki.runtime.unit.data.bool.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LAndBooleanBinaryOperation extends LBooleanBinaryOperation
{
	public static final LInstanceUnitDescriptor<LAndBooleanBinaryOperation> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("&&", LAndBooleanBinaryOperation.class);

	private LAndBooleanBinaryOperation()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	protected LBoolean execute(LBoolean leftOperand, LBoolean rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() && rightOperand.getValue());
	}
}
