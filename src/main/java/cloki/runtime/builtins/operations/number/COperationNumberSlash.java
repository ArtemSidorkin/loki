package cloki.runtime.builtins.operations.number;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatypes.CNumber;
import cloki.runtime.datatypes.CUnit;

public class COperationNumberSlash extends COperationHomogeneousNumber
{
	public static final COperationNumberSlash instance = new COperationNumberSlash();

	private COperationNumberSlash()
	{
		super(CConstOperator.SLASH);
	}

	@Override
	protected CUnit operation(CNumber leftOperand, CNumber rightOperand)
	{
		return new CNumber(leftOperand.getValue() / rightOperand.getValue());
	}
}
