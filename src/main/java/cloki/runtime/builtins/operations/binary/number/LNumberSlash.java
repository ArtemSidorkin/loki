package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.number.LNumber;
import cloki.runtime.datatype.LUnit;

public class LNumberSlash extends LNumberOperation
{
	public static final LNumberSlash instance = new LNumberSlash();

	private LNumberSlash()
	{
		super(LBinaryOperator.SLASH);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() / rightOperand.getValue());
	}
}
