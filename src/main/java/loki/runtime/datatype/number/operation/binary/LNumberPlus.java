package loki.runtime.datatype.number.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LNumberPlus extends LNumberOperation
{
	public static final LNumberPlus instance = new LNumberPlus();

	private LNumberPlus()
	{
		super(LBinaryOperator.PLUS);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() + rightOperand.getValue());
	}
}
