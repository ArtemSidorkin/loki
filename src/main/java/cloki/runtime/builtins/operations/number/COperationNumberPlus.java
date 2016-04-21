package cloki.runtime.builtins.operations.number;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatypes.CNumber;
import cloki.runtime.datatypes.CUnit;

public class COperationNumberPlus extends COperationHomogeneousNumber
{
	public static final COperationNumberPlus instance = new COperationNumberPlus();

	private COperationNumberPlus()
	{
		super(CConstOperator.PLUS);
	}

	@Override
	protected CUnit operation(CNumber leftOperand, CNumber rightOperand)
	{
		return new CNumber(leftOperand.getValue() + rightOperand.getValue());
	}
}
