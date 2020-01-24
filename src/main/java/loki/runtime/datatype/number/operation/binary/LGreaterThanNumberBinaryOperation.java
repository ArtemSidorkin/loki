package loki.runtime.datatype.number.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LBoolean;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LGreaterThanNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LGreaterThanNumberBinaryOperation instance = new LGreaterThanNumberBinaryOperation();

	private LGreaterThanNumberBinaryOperation()
	{
		super(LBinaryOperator.GREATER_THAN);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.value > rightOperand.value);
	}
}
