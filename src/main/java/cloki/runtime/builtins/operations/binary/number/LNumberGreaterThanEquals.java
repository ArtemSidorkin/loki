package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class LNumberGreaterThanEquals extends LNumberOperation
{
	public static final LNumberGreaterThanEquals instance = new LNumberGreaterThanEquals();

	private LNumberGreaterThanEquals()
	{
		super(LBinaryOperator.GREATER_THAN_EQUALS);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.getValue() >= rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
