package loki.runtime.datatype.number.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

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
