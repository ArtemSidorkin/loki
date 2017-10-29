package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LUnit;

public class LOperationNumberPlus extends LOperationHomogeneousNumber
{
	public static final LOperationNumberPlus instance = new LOperationNumberPlus();

	private LOperationNumberPlus()
	{
		super(LBinaryOperator.PLUS);
	}

	@Override
	protected LUnit _operation(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() + rightOperand.getValue());
	}
}
