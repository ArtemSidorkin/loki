package loki.runtime.datatype.number.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LMultiplicationNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LMultiplicationNumberBinaryOperation instance = new LMultiplicationNumberBinaryOperation();

	private LMultiplicationNumberBinaryOperation()
	{
		super(LBinaryOperator.STAR);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.value * rightOperand.value);
	}
}
