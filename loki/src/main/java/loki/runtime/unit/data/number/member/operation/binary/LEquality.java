package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LEquality extends LNumberBinaryOperation<LEquality>
{
	public static final LInstanceDescriptor<LEquality> DESCRIPTOR =
		new LInstanceDescriptor<>("==", LEquality.class, LEquality::new);

	private LEquality()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() == rightOperand.getValue());
	}
}
