package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LInequality extends LNumberBinaryOperation<LInequality>
{
	public static final LInstanceDescriptor<LInequality> DESCRIPTOR =
		new LInstanceDescriptor<>("!=", LInequality.class, LInequality::new);

	private LInequality()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() != rightOperand.getValue());
	}
}
