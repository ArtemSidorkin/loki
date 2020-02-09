package loki.runtime.unit.unit.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.unit.LUnit;

public class LInequalityUnitBinaryOperation extends LUnitBinaryOperation
{
	public static final LInequalityUnitBinaryOperation instance = new LInequalityUnitBinaryOperation();

	private LInequalityUnitBinaryOperation()
	{
		super(LBinaryOperator.BANG_EQUALS);
	}

	@Override
	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		return LBoolean.valueOf(leftOperand != rightOperand);
	}
}
