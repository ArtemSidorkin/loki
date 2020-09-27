package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LMultiplication extends LNumberBinaryOperation<LMultiplication>
{
	public static final LInstanceDescriptor<LMultiplication> DESCRIPTOR =
		new LInstanceDescriptor<>("*", LMultiplication.class, LMultiplication::new);

	private LMultiplication()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() * rightOperand.getValue());
	}
}
