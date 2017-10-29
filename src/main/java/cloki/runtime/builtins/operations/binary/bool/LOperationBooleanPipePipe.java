package cloki.runtime.builtins.operations.binary.bool;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LBoolean;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class LOperationBooleanPipePipe extends LOperationHomogeneousBoolean
{
	public static final LOperationBooleanPipePipe instance = new LOperationBooleanPipePipe();

	private LOperationBooleanPipePipe()
	{
		super(LBinaryOperator.PIPE_PIPE);
	}

	@Override
	LUnit _operation(LBoolean leftOperand, LBoolean rightOperand)
	{
		return leftOperand.getValue() || rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
