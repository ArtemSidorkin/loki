package loki.runtime.builtin.operation.binary.bool;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LBoolean;
import loki.runtime.datatype.unit.LUnit;

public class LBooleanPipePipe extends LBooleanOperation
{
	public static final LBooleanPipePipe instance = new LBooleanPipePipe();

	private LBooleanPipePipe()
	{
		super(LBinaryOperator.PIPE_PIPE);
	}

	@Override
	protected LUnit __execute(LBoolean leftOperand, LBoolean rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() || rightOperand.getValue());
	}
}
