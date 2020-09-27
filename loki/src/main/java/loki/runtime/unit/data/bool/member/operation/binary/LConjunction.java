package loki.runtime.unit.data.bool.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LConjunction extends LBooleanBinaryOperation<LConjunction>
{
	public static final LInstanceDescriptor<LConjunction> DESCRIPTOR =
		new LInstanceDescriptor<>("&&", LConjunction.class, LConjunction::new);

	private LConjunction()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LBoolean execute(LBoolean leftOperand, LBoolean rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() && rightOperand.getValue());
	}
}
