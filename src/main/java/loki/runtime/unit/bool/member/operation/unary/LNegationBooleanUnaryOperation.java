package loki.runtime.unit.bool.member.operation.unary;

import loki.runtime.constant.LUnaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.unit.LUnit;

public class LNegationBooleanUnaryOperation extends LBooleanUnaryOperation
{
	public static final LNegationBooleanUnaryOperation instance = new LNegationBooleanUnaryOperation();

	private LNegationBooleanUnaryOperation()
	{
		super(LUnaryOperator.BANG);
	}

	@Override
	protected LUnit execute(LBoolean operand)
	{
		return LBoolean.valueOf(!operand.getValue());
	}
}
