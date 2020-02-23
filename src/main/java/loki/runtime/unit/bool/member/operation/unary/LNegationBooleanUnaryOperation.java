package loki.runtime.unit.bool.member.operation.unary;

import loki.runtime.constant.LUnaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LNegationBooleanUnaryOperation extends LBooleanUnaryOperation
{
	public static final String TYPE_NAME = LUnaryOperator.BANG.symbol;
	public static final LType TYPE = new LType(TYPE_NAME, LNegationBooleanUnaryOperation.class);

	public static final LNegationBooleanUnaryOperation INSTANCE = new LNegationBooleanUnaryOperation();

	private LNegationBooleanUnaryOperation()
	{
		super(TYPE);
	}

	@Override
	protected LUnit execute(LBoolean operand)
	{
		return LBoolean.valueOf(!operand.getValue());
	}
}
