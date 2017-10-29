package cloki.runtime.builtins.operations.number;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LUnit;

public class COperationNumberMinus extends COperationHomogeneousNumber
{
	public static final COperationNumberMinus instance = new COperationNumberMinus();

	private COperationNumberMinus()
	{
		super(CConstOperator.MINUS);
	}

	@Override
	protected LUnit operation(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() - rightOperand.getValue());
	}
}
