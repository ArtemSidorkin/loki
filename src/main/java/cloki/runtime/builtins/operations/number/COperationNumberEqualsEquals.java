package cloki.runtime.builtins.operations.number;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatypes.CFalse;
import cloki.runtime.datatypes.CNumber;
import cloki.runtime.datatypes.CTrue;
import cloki.runtime.datatypes.CUnit;

public class COperationNumberEqualsEquals extends COperationHomogeneousNumber
{
	public static final COperationNumberEqualsEquals instance = new COperationNumberEqualsEquals();

	private COperationNumberEqualsEquals()
	{
		super(CConstOperator.EQUALS_EQUALS);
	}

	@Override
	protected CUnit operation(CNumber leftOperand, CNumber rightOperand)
	{
		return leftOperand.getValue() == rightOperand.getValue() ? CTrue.instance : CFalse.instance;
	}
}
