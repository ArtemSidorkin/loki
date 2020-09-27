package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LGreaterThanEquals extends LNumberBinaryOperation<LGreaterThanEquals>
{
	public static final LInstanceDescriptor<LGreaterThanEquals> DESCRIPTOR =
		new LInstanceDescriptor<>(">=", LGreaterThanEquals.class, LGreaterThanEquals::new);

	private LGreaterThanEquals()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() >= rightOperand.getValue());
	}
}
