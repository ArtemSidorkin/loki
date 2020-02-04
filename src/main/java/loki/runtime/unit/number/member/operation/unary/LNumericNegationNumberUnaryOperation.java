package loki.runtime.unit.number.member.operation.unary;

import loki.runtime.constant.LUnaryOperator;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;

public class LNumericNegationNumberUnaryOperation extends LNumberUnaryOperation
{
	public static final LNumericNegationNumberUnaryOperation instance = new LNumericNegationNumberUnaryOperation();

	private LNumericNegationNumberUnaryOperation()
	{
		super(LUnaryOperator.MINUS);
	}

	@Override
	protected LUnit execute(LNumber operand)
	{
		return new LNumber(-operand.value);
	}
}
