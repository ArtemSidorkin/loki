package loki.runtime.datatype.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LInequalityNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LInequalityNumberBinaryOperation instance = new LInequalityNumberBinaryOperation();

	private LInequalityNumberBinaryOperation()
	{
		super(LBinaryOperator.BANG_EQUALS);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.value != rightOperand.value ? LTrue.instance : LFalse.instance;
	}
}
