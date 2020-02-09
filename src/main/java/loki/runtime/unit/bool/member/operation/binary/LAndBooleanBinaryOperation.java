package loki.runtime.unit.bool.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;

public class LAndBooleanBinaryOperation extends LBooleanBinaryOperation
{
	public static final LAndBooleanBinaryOperation instance = new LAndBooleanBinaryOperation();

	private LAndBooleanBinaryOperation()
	{
		super(LBinaryOperator.AMPERSAND_AMPERSAND);
	}

	@Override
	protected LBoolean execute(LBoolean leftOperand, LBoolean rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() && rightOperand.getValue());
	}
}
