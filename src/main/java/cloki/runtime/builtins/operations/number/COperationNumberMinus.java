package cloki.runtime.builtins.operations.number;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatypes.CNumber;
import cloki.runtime.datatypes.CUnit;

public class COperationNumberMinus extends COperationHomogeneousNumber
{
	public static final COperationNumberMinus instance = new COperationNumberMinus();

	private COperationNumberMinus()
	{
		super(CConstOperator.MINUS);
	}

	@Override
	protected CUnit operation(CNumber leftOperand, CNumber rightOperand)
	{
		return new CNumber(leftOperand.getValue() - rightOperand.getValue());
	}
}
