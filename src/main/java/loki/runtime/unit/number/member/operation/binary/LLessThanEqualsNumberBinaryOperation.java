package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LLessThanEqualsNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final String TYPE_NAME = LBinaryOperator.LESS_THAN_EQUALS.symbol;
	public static final LType TYPE = new LType(TYPE_NAME, LLessThanEqualsNumberBinaryOperation.class);

	public static final LLessThanEqualsNumberBinaryOperation INSTANCE = new LLessThanEqualsNumberBinaryOperation();

	private LLessThanEqualsNumberBinaryOperation()
	{
		super(TYPE);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() <= rightOperand.getValue());
	}
}
