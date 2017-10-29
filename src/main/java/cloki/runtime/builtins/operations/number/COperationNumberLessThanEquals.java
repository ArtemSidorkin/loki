package cloki.runtime.builtins.operations.number;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatypes.CFalse;
import cloki.runtime.datatypes.CNumber;
import cloki.runtime.datatypes.CTrue;
import cloki.runtime.datatypes.CUnit;

public class COperationNumberLessThanEquals extends COperationHomogeneousNumber
{
	public static final COperationNumberLessThanEquals instance = new COperationNumberLessThanEquals();

	private COperationNumberLessThanEquals()
	{
		super(CConstOperator.LESS_THAN_EQUALS);
	}

	@Override
	protected CUnit operation(CNumber leftOperand, CNumber rightOperand)
	{
		return leftOperand.getValue() <= rightOperand.getValue() ? CTrue.instance : CFalse.instance;
	}
}
