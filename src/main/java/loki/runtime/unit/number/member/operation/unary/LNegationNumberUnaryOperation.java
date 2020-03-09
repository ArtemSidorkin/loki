package loki.runtime.unit.number.member.operation.unary;

import loki.runtime.constant.LUnaryOperator;
import loki.runtime.unit.number.LNumber;
import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;

public class LNegationNumberUnaryOperation extends LNumberUnaryOperation
{
	public static final String TYPE_NAME = LUnaryOperator.MINUS.symbol;
	public static final LType TYPE = new LType(TYPE_NAME, LNegationNumberUnaryOperation.class);

	public static final LNegationNumberUnaryOperation INSTANCE = new LNegationNumberUnaryOperation();

	private LNegationNumberUnaryOperation()
	{
		super(TYPE);
	}

	@Override
	protected LUnit execute(LNumber operand)
	{
		return new LNumber(-operand.getValue());
	}
}
