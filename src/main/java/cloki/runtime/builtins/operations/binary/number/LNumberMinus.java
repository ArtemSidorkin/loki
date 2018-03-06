package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.number.LNumber;
import cloki.runtime.datatype.LUnit;

public class LNumberMinus extends LNumberOperation
{
	public static final LNumberMinus instance = new LNumberMinus();

	private LNumberMinus()
	{
		super(LBinaryOperator.MINUS);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() - rightOperand.getValue());
	}
}
