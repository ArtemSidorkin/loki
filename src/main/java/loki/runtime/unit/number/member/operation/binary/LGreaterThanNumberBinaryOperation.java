package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;

public class LGreaterThanNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LGreaterThanNumberBinaryOperation instance = new LGreaterThanNumberBinaryOperation();

	private LGreaterThanNumberBinaryOperation()
	{
		super(LBinaryOperator.GREATER_THAN);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() > rightOperand.getValue());
	}
}