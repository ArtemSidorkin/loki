package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LUnit;

public class LOperationNumberSlash extends LOperationHomogeneousNumber
{
	public static final LOperationNumberSlash instance = new LOperationNumberSlash();

	private LOperationNumberSlash()
	{
		super(LBinaryOperator.SLASH);
	}

	@Override
	protected LUnit _operation(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() / rightOperand.getValue());
	}
}
