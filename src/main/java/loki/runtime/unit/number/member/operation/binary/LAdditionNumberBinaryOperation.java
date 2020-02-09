package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;

public class LAdditionNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LAdditionNumberBinaryOperation instance = new LAdditionNumberBinaryOperation();

	private LAdditionNumberBinaryOperation()
	{
		super(LBinaryOperator.PLUS);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.value + rightOperand.value);
	}
}
