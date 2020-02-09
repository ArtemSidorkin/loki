package loki.runtime.unit.unit.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.unit.LUnit;

public class LEqualityUnitBinaryOperation extends LUnitBinaryOperation
{
	public static final LEqualityUnitBinaryOperation instance = new LEqualityUnitBinaryOperation();

	private LEqualityUnitBinaryOperation()
	{
		super(LBinaryOperator.EQUALS_EQUALS);
	}

	@Override
	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		return LBoolean.valueOf(leftOperand == rightOperand);
	}
}
