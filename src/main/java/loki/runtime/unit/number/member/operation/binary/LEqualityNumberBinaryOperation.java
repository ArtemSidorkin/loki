package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;

public class LEqualityNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LEqualityNumberBinaryOperation instance = new LEqualityNumberBinaryOperation();

	private LEqualityNumberBinaryOperation()
	{
		super(LBinaryOperator.EQUALS_EQUALS);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.value == rightOperand.value);
	}
}
