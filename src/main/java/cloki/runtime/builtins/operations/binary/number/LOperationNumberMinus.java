package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LUnit;

public class LOperationNumberMinus extends LOperationHomogeneousNumber
{
	public static final LOperationNumberMinus instance = new LOperationNumberMinus();

	private LOperationNumberMinus()
	{
		super(LBinaryOperator.MINUS);
	}

	@Override
	protected LUnit _operation(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() - rightOperand.getValue());
	}
}
