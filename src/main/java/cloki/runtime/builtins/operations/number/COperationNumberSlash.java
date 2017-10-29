package cloki.runtime.builtins.operations.number;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LUnit;

public class COperationNumberSlash extends COperationHomogeneousNumber
{
	public static final COperationNumberSlash instance = new COperationNumberSlash();

	private COperationNumberSlash()
	{
		super(CConstOperator.SLASH);
	}

	@Override
	protected LUnit operation(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() / rightOperand.getValue());
	}
}
