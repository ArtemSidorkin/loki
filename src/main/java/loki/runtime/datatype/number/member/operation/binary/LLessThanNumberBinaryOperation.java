package loki.runtime.datatype.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LLessThanNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LLessThanNumberBinaryOperation instance = new LLessThanNumberBinaryOperation();

	private LLessThanNumberBinaryOperation()
	{
		super(LBinaryOperator.LESS_THAN);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.value < rightOperand.value ? LTrue.instance : LFalse.instance;
	}
}
