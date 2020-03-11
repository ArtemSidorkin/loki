package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LMultiplicationNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LInstanceUnitDescriptor<LMultiplicationNumberBinaryOperation> DESCRIPTOR =
		new LInstanceUnitDescriptor<>(
			"*", LMultiplicationNumberBinaryOperation.class, LMultiplicationNumberBinaryOperation::new
		);

	private LMultiplicationNumberBinaryOperation()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() * rightOperand.getValue());
	}
}
