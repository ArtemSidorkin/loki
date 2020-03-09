package loki.runtime.unit.data.bool.member.operation.unary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LNegationBooleanUnaryOperation extends LBooleanUnaryOperation
{
	public static final LInstanceUnitDescriptor<LNegationBooleanUnaryOperation> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("!_",LNegationBooleanUnaryOperation.class);

	private LNegationBooleanUnaryOperation()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	protected LUnit execute(LBoolean operand)
	{
		return LBoolean.valueOf(!operand.getValue());
	}
}
