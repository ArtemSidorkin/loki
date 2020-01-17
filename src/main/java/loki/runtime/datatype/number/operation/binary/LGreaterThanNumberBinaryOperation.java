package loki.runtime.datatype.number.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
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
		return leftOperand.value > rightOperand.value ? LTrue.instance : LFalse.instance;
	}
}
