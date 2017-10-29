package cloki.runtime.builtins.operations.binary.bool;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LBoolean;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class LBooleanPipePipe extends LBooleanOperation
{
	public static final LBooleanPipePipe instance = new LBooleanPipePipe();

	private LBooleanPipePipe()
	{
		super(LBinaryOperator.PIPE_PIPE);
	}

	@Override
	protected LUnit __execute(LBoolean leftOperand, LBoolean rightOperand)
	{
		return leftOperand.getValue() || rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
