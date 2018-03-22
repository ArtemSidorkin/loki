package loki.runtime.datatype.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LDivisionNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LDivisionNumberBinaryOperation instance = new LDivisionNumberBinaryOperation();

	private LDivisionNumberBinaryOperation()
	{
		super(LBinaryOperator.SLASH);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.value / rightOperand.value);
	}
}
