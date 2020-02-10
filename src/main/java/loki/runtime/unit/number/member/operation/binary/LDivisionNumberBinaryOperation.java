package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;

public class LDivisionNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LDivisionNumberBinaryOperation instance = new LDivisionNumberBinaryOperation();

	private LDivisionNumberBinaryOperation()
	{
		super(LBinaryOperator.SLASH);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() / rightOperand.getValue());
	}
}
