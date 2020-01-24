package loki.runtime.datatype.number.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LBoolean;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LEqualityNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LEqualityNumberBinaryOperation instance = new LEqualityNumberBinaryOperation();

	private LEqualityNumberBinaryOperation()
	{
		super(LBinaryOperator.EQUALS_EQUALS);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.value == rightOperand.value);
	}
}
