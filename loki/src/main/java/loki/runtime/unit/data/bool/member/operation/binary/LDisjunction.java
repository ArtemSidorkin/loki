package loki.runtime.unit.data.bool.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LDisjunction extends LBooleanBinaryOperation<LDisjunction>
{
	public static final LInstanceDescriptor<LDisjunction> DESCRIPTOR =
		new LInstanceDescriptor<>("||", LDisjunction.class, LDisjunction::new);

	private LDisjunction()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LBoolean execute(LBoolean leftOperand, LBoolean rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() || rightOperand.getValue());
	}
}
