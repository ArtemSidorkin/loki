package cloki.runtime.builtins.operations.number;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatypes.CFalse;
import cloki.runtime.datatypes.CNumber;
import cloki.runtime.datatypes.CTrue;
import cloki.runtime.datatypes.CUnit;

public class COperationNumberGreaterThanEquals extends COperationHomogeneousNumber
{
	public static final COperationNumberGreaterThanEquals instance = new COperationNumberGreaterThanEquals();

	private COperationNumberGreaterThanEquals()
	{
		super(CConstOperator.GREATER_THAN_EQUALS);
	}

	@Override
	protected CUnit operation(CNumber leftOperand, CNumber rightOperand)
	{
		return leftOperand.getValue() >= rightOperand.getValue() ? CTrue.instance : CFalse.instance;
	}
}
