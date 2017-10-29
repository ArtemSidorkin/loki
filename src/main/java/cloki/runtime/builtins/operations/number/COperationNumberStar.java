package cloki.runtime.builtins.operations.number;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatypes.CNumber;
import cloki.runtime.datatypes.CUnit;

public class COperationNumberStar extends COperationHomogeneousNumber
{
	public static final COperationNumberStar instance = new COperationNumberStar();

	private COperationNumberStar()
	{
		super(CConstOperator.STAR);
	}

	@Override
	protected CUnit operation(CNumber leftOperand, CNumber rightOperand)
	{
		return new CNumber(leftOperand.getValue() * rightOperand.getValue());
	}
}
