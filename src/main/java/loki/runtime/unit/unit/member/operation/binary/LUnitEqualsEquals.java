package loki.runtime.unit.unit.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.member.operation.LBinaryOperation;
import loki.runtime.unit.unit.LUnit;

public class LUnitEqualsEquals extends LBinaryOperation<LUnit, LUnit>
{
	public static final LUnitEqualsEquals instance = new LUnitEqualsEquals();

	private LUnitEqualsEquals()
	{
		super(LBinaryOperator.EQUALS_EQUALS);
	}

	@Override
	protected LUnit _execute(LUnit leftOperand, LUnit rightOperand)
	{
		return LBoolean.valueOf(leftOperand == rightOperand);
	}
}
