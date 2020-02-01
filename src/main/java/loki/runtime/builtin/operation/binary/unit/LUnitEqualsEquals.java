package loki.runtime.builtin.operation.binary.unit;

import loki.runtime.builtin.operation.binary.LBinaryOperation;
import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LBoolean;
import loki.runtime.datatype.unit.LUnit;

public class LUnitEqualsEquals extends LBinaryOperation<LUnit, LUnit, LUnit>
{
	public static final LUnitEqualsEquals instance = new LUnitEqualsEquals();

	private LUnitEqualsEquals()
	{
		super(LBinaryOperator.EQUALS_EQUALS);
	}

	@Override
	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		return LBoolean.valueOf(leftOperand == rightOperand);
	}
}
