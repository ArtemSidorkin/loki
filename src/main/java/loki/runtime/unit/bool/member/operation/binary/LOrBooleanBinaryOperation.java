package loki.runtime.unit.bool.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.type.LType;

public class LOrBooleanBinaryOperation extends LBooleanBinaryOperation
{
	public static final String TYPE_NAME = LBinaryOperator.PIPE_PIPE.symbol;
	public static final LType TYPE = new LType(TYPE_NAME, LOrBooleanBinaryOperation.class);

	public static final LOrBooleanBinaryOperation INSTANCE = new LOrBooleanBinaryOperation();

	private LOrBooleanBinaryOperation()
	{
		super(TYPE);
	}

	@Override
	protected LBoolean execute(LBoolean leftOperand, LBoolean rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() || rightOperand.getValue());
	}
}
