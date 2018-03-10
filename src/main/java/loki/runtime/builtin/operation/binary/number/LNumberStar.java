package loki.runtime.builtin.operation.binary.number;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.LUnit;

public class LNumberStar extends LNumberOperation
{
	public static final LNumberStar instance = new LNumberStar();

	private LNumberStar()
	{
		super(LBinaryOperator.STAR);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() * rightOperand.getValue());
	}
}
