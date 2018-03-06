package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.number.LNumber;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class LNumberEqualsEquals extends LNumberOperation
{
	public static final LNumberEqualsEquals instance = new LNumberEqualsEquals();

	private LNumberEqualsEquals()
	{
		super(LBinaryOperator.EQUALS_EQUALS);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.getValue() == rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
