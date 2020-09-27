package loki.runtime.unit.unit.member.operation.binary;

import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LInequality extends LUnitBinaryOperation<LInequality>
{
	public static final LInstanceDescriptor<LInequality> DESCRIPTOR =
		new LInstanceDescriptor<>("!=", LInequality.class, LInequality::new);

	private LInequality()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		return leftOperand._equals(rightOperand).invert();
	}
}
