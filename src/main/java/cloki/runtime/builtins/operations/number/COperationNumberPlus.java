package cloki.runtime.builtins.operations.number;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LUnit;

public class COperationNumberPlus extends COperationHomogeneousNumber
{
	public static final COperationNumberPlus instance = new COperationNumberPlus();

	private COperationNumberPlus()
	{
		super(LBinaryOperator.PLUS);
	}

	@Override
	protected LUnit operation(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() + rightOperand.getValue());
	}
}
