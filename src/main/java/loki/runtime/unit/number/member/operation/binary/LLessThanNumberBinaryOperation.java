package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;

public class LLessThanNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LLessThanNumberBinaryOperation instance = new LLessThanNumberBinaryOperation();

	private LLessThanNumberBinaryOperation()
	{
		super(LBinaryOperator.LESS_THAN);
	}

	@Override
	protected LUnit _execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.value < rightOperand.value);
	}
}
