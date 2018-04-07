package loki.runtime.datatype.number.member.operation.unary;

import loki.runtime.constant.LUnaryOperator;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.LNumber;

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
