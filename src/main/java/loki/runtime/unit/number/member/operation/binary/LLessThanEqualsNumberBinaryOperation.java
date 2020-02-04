package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;

public class LLessThanEqualsNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LLessThanEqualsNumberBinaryOperation instance = new LLessThanEqualsNumberBinaryOperation();

	private LLessThanEqualsNumberBinaryOperation()
	{
		super(LBinaryOperator.LESS_THAN_EQUALS);
	}

	@Override
	protected LUnit _execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.value <= rightOperand.value);
	}
}
