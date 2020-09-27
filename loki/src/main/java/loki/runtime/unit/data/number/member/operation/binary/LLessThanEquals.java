package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LLessThanEquals extends LNumberBinaryOperation<LLessThanEquals>
{
	public static final LInstanceDescriptor<LLessThanEquals> DESCRIPTOR =
		new LInstanceDescriptor<>("<=", LLessThanEquals.class, LLessThanEquals::new);

	private LLessThanEquals()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() <= rightOperand.getValue());
	}
}
