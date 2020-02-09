package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;

public class LSubtractionNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LSubtractionNumberBinaryOperation instance = new LSubtractionNumberBinaryOperation();

	private LSubtractionNumberBinaryOperation()
	{
		super(LBinaryOperator.MINUS);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.value - rightOperand.value);
	}
}
