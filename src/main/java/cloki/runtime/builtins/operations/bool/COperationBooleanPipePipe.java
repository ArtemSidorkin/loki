package cloki.runtime.builtins.operations.bool;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatype.LBoolean;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class COperationBooleanPipePipe extends COperationHomogeneousBoolean
{
	public static final COperationBooleanPipePipe instance = new COperationBooleanPipePipe();

	private COperationBooleanPipePipe()
	{
		super(CConstOperator.PIPE_PIPE);
	}

	@Override
	protected LUnit operation(LBoolean leftOperand, LBoolean rightOperand)
	{
		return leftOperand.getValue() || rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
