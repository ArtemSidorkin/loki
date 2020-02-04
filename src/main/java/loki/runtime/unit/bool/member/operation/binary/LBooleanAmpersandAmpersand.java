package loki.runtime.unit.bool.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;

public class LBooleanAmpersandAmpersand extends LBooleanOperation
{
	public static final LBooleanAmpersandAmpersand instance = new LBooleanAmpersandAmpersand();

	private LBooleanAmpersandAmpersand()
	{
		super(LBinaryOperator.AMPERSAND_AMPERSAND);
	}

	@Override
	protected boolean __execute(boolean leftOperand, boolean rightOperand)
	{
		return leftOperand && rightOperand;
	}
}
