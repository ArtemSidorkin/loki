package loki.runtime.unit.bool.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.type.LType;

public class LAndBooleanBinaryOperation extends LBooleanBinaryOperation
{
	public static final String TYPE_NAME = LBinaryOperator.AMPERSAND_AMPERSAND.symbol;
	public static final LType TYPE = new LType(TYPE_NAME, LAndBooleanBinaryOperation.class);

	public static final LAndBooleanBinaryOperation INSTANCE = new LAndBooleanBinaryOperation();

	private LAndBooleanBinaryOperation()
	{
		super(TYPE);
	}

	@Override
	protected LBoolean execute(LBoolean leftOperand, LBoolean rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() && rightOperand.getValue());
	}
}
