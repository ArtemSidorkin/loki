package loki.runtime.unit.unit.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;

public class LEqualityUnitBinaryOperation extends LUnitBinaryOperation
{
	public static final String TYPE_NAME = LBinaryOperator.EQUALS_EQUALS.symbol;
	public static final LType TYPE = new LType(TYPE_NAME, LEqualityUnitBinaryOperation.class);

	public static final LEqualityUnitBinaryOperation INSTANCE = new LEqualityUnitBinaryOperation();

	private LEqualityUnitBinaryOperation()
	{
		super(TYPE);
	}

	@Override
	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		return LBoolean.valueOf(leftOperand == rightOperand);
	}
}
