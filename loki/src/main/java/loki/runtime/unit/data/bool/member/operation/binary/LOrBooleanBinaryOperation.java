package loki.runtime.unit.data.bool.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LOrBooleanBinaryOperation extends LBooleanBinaryOperation
{
	public static final LInstanceUnitDescriptor<LOrBooleanBinaryOperation> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("||", LOrBooleanBinaryOperation.class, LOrBooleanBinaryOperation::new);

	private LOrBooleanBinaryOperation()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	protected LBoolean execute(LBoolean leftOperand, LBoolean rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() || rightOperand.getValue());
	}
}
