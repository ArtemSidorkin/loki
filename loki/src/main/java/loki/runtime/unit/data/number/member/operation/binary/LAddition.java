package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LAddition extends LNumberBinaryOperation<LAddition>
{
	public static final LInstanceDescriptor<LAddition> DESCRIPTOR =
		new LInstanceDescriptor<>("+", LAddition.class, LAddition::new);

	private LAddition()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() + rightOperand.getValue());
	}
}
