package loki.runtime.datatype.number.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

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
