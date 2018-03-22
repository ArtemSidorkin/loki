package loki.runtime.datatype.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LAdditionNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LAdditionNumberBinaryOperation instance = new LAdditionNumberBinaryOperation();

	private LAdditionNumberBinaryOperation()
	{
		super(LBinaryOperator.PLUS);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.value + rightOperand.value);
	}
}
