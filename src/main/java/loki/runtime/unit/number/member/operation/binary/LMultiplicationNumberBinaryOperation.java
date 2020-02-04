package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;

public class LMultiplicationNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LMultiplicationNumberBinaryOperation instance = new LMultiplicationNumberBinaryOperation();

	private LMultiplicationNumberBinaryOperation()
	{
		super(LBinaryOperator.STAR);
	}

	@Override
	protected LUnit _execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.value * rightOperand.value);
	}
}
