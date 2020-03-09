package loki.runtime.unit.data.number.member.operation.unary;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LNegationNumberUnaryOperation extends LNumberUnaryOperation
{
	public static final LInstanceUnitDescriptor<LNegationNumberUnaryOperation> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("-_", LNegationNumberUnaryOperation.class);

	private LNegationNumberUnaryOperation()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	protected LUnit execute(LNumber operand)
	{
		return new LNumber(-operand.getValue());
	}
}
