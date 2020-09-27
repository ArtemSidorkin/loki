package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LDivision extends LNumberBinaryOperation<LDivision>
{
	public static final LInstanceDescriptor<LDivision> DESCRIPTOR =
		new LInstanceDescriptor<>("/", LDivision.class, LDivision::new);

	private LDivision()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() / rightOperand.getValue());
	}
}
