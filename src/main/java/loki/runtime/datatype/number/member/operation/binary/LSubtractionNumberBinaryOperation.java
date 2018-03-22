package loki.runtime.datatype.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LSubtractionNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LSubtractionNumberBinaryOperation instance = new LSubtractionNumberBinaryOperation();

	private LSubtractionNumberBinaryOperation()
	{
		super(LBinaryOperator.MINUS);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.value - rightOperand.value);
	}
}
