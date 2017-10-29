package cloki.runtime.builtins.operations.bool;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatypes.CBoolean;
import cloki.runtime.datatypes.CFalse;
import cloki.runtime.datatypes.CTrue;
import cloki.runtime.datatypes.CUnit;

public class COperationBooleanPipePipe extends COperationHomogeneousBoolean
{
	public static final COperationBooleanPipePipe instance = new COperationBooleanPipePipe();

	private COperationBooleanPipePipe()
	{
		super(CConstOperator.PIPE_PIPE);
	}

	@Override
	protected CUnit operation(CBoolean leftOperand, CBoolean rightOperand)
	{
		return leftOperand.getValue() || rightOperand.getValue() ? CTrue.instance : CFalse.instance;
	}
}
