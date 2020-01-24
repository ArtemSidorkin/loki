package loki.runtime.datatype.number.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LBoolean;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LLessThanNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LLessThanNumberBinaryOperation instance = new LLessThanNumberBinaryOperation();

	private LLessThanNumberBinaryOperation()
	{
		super(LBinaryOperator.LESS_THAN);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.value < rightOperand.value);
	}
}
