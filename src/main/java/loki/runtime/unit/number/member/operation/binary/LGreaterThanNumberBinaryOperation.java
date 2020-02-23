package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LGreaterThanNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final String TYPE_NAME = LBinaryOperator.GREATER_THAN.symbol;
	public static final LType TYPE = new LType(TYPE_NAME, LGreaterThanNumberBinaryOperation.class);

	public static final LGreaterThanNumberBinaryOperation INSTANCE = new LGreaterThanNumberBinaryOperation();

	private LGreaterThanNumberBinaryOperation()
	{
		super(TYPE);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return LBoolean.valueOf(leftOperand.getValue() > rightOperand.getValue());
	}
}
