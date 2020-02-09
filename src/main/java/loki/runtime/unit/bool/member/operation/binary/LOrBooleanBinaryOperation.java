package loki.runtime.unit.bool.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;

public class LOrBooleanBinaryOperation extends LBooleanBinaryOperation
{
	public static final LOrBooleanBinaryOperation instance = new LOrBooleanBinaryOperation();

	private LOrBooleanBinaryOperation()
	{
		super(LBinaryOperator.PIPE_PIPE);
	}

	@Override
	protected LBoolean execute(LBoolean leftOperand, LBoolean rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() || rightOperand.getValue());
	}
}
