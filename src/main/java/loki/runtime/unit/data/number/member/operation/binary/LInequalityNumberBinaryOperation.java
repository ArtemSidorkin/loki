package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LInequalityNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LInstanceUnitDescriptor<LInequalityNumberBinaryOperation> DESCRIPTOR =
		new LInstanceUnitDescriptor<>(
			"!=", LInequalityNumberBinaryOperation.class, LInequalityNumberBinaryOperation::new
		);

	private LInequalityNumberBinaryOperation()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() != rightOperand.getValue());
	}
}
