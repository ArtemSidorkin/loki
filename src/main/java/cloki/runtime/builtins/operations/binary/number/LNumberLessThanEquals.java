package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.number.LNumber;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class LNumberLessThanEquals extends LNumberOperation
{
	public static final LNumberLessThanEquals instance = new LNumberLessThanEquals();

	private LNumberLessThanEquals()
	{
		super(LBinaryOperator.LESS_THAN_EQUALS);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.getValue() <= rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
