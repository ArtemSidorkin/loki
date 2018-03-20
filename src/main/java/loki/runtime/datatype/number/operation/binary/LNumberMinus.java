package loki.runtime.datatype.number.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

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
