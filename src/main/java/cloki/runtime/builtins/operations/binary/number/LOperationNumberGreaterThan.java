package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class LOperationNumberGreaterThan extends LOperationHomogeneousNumber
{
	public static final LOperationNumberGreaterThan instance = new LOperationNumberGreaterThan();

	private LOperationNumberGreaterThan()
	{
		super(LBinaryOperator.GREATER_THAN);
	}

	@Override
	protected LUnit _operation(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.getValue() > rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
