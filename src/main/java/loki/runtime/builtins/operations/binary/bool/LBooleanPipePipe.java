package loki.runtime.builtins.operations.binary.bool;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LBoolean;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LUnit;

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
