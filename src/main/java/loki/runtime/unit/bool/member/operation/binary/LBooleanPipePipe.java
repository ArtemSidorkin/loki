package loki.runtime.unit.bool.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;

public class LBooleanPipePipe extends LBooleanOperation
{
	public static final LBooleanPipePipe instance = new LBooleanPipePipe();

	private LBooleanPipePipe()
	{
		super(LBinaryOperator.PIPE_PIPE);
	}

	@Override
	protected boolean __execute(boolean leftOperand, boolean rightOperand)
	{
		return leftOperand || rightOperand;
	}
}
