package loki.runtime.builtins.operations.binary.number;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.LUnit;

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
