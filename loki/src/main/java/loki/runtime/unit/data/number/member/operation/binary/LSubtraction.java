package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LSubtraction extends LNumberBinaryOperation<LSubtraction>
{
	public static final LInstanceDescriptor<LSubtraction> DESCRIPTOR =
		new LInstanceDescriptor<>("-", LSubtraction.class, LSubtraction::new);

	private LSubtraction()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() - rightOperand.getValue());
	}
}
