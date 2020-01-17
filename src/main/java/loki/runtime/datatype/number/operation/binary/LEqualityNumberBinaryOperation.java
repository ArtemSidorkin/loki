package loki.runtime.datatype.number.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
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
		return leftOperand.value == rightOperand.value ? LTrue.instance : LFalse.instance;
	}
}
