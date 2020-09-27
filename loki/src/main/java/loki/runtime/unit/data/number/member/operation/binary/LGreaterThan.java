package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LGreaterThan extends LNumberBinaryOperation<LGreaterThan>
{
	public static final LInstanceDescriptor<LGreaterThan> DESCRIPTOR =
		new LInstanceDescriptor<>(">", LGreaterThan.class, LGreaterThan::new);

	private LGreaterThan()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() > rightOperand.getValue());
	}
}
