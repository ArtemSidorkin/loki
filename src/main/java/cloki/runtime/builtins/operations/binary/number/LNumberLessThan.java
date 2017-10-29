package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class LNumberLessThan extends LNumberOperation
{
	public static final LNumberLessThan instance = new LNumberLessThan();

	private LNumberLessThan()
	{
		super(LBinaryOperator.LESS_THAN);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.getValue() < rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
