package loki.runtime.builtin.operation.binary.number;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.LUnit;

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
