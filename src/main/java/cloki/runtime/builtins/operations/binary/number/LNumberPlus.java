package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.number.LNumber;
import cloki.runtime.datatype.LUnit;

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
