package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LLessThan extends LNumberBinaryOperation<LLessThan>
{
	public static final LInstanceDescriptor<LLessThan> DESCRIPTOR =
		new LInstanceDescriptor<>("<", LLessThan.class, LLessThan::new);

	private LLessThan()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() < rightOperand.getValue());
	}
}
