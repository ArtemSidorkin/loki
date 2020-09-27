package loki.runtime.unit.data.bool.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LEquality extends LBooleanBinaryOperation<LEquality>
{
	public static final LInstanceDescriptor<LEquality> DESCRIPTOR =
		new LInstanceDescriptor<>("==", LEquality.class, LEquality::new);

	private LEquality()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LBoolean leftOperand, LBoolean rightOperand)
	{
		return leftOperand._equals(rightOperand);
	}
}
