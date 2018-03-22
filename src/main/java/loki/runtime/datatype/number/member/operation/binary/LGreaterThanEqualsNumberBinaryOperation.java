package loki.runtime.datatype.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LGreaterThanEqualsNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final LGreaterThanEqualsNumberBinaryOperation instance =
		new LGreaterThanEqualsNumberBinaryOperation();

	private LGreaterThanEqualsNumberBinaryOperation()
	{
		super(LBinaryOperator.GREATER_THAN_EQUALS);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.value >= rightOperand.value ? LTrue.instance : LFalse.instance;
	}
}
