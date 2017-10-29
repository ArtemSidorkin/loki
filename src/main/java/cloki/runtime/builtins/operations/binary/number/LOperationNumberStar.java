package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LUnit;

public class LOperationNumberStar extends LOperationHomogeneousNumber
{
	public static final LOperationNumberStar instance = new LOperationNumberStar();

	private LOperationNumberStar()
	{
		super(LBinaryOperator.STAR);
	}

	@Override
	protected LUnit _operation(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() * rightOperand.getValue());
	}
}
