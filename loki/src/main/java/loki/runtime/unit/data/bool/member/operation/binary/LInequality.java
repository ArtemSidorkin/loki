package loki.runtime.unit.data.bool.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LInequality extends LBooleanBinaryOperation<LInequality>
{
	public static final LInstanceDescriptor<LInequality> DESCRIPTOR =
		new LInstanceDescriptor<>("!=", LInequality.class, LInequality::new);

	private LInequality()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LBoolean leftOperand, LBoolean rightOperand)
	{
		return leftOperand._equals(rightOperand).invert();
	}
}
