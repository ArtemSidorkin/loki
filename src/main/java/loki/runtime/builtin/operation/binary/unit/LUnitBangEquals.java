package loki.runtime.builtin.operation.binary.unit;

import loki.runtime.builtin.operation.binary.LBinaryOperation;
import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LBoolean;
import loki.runtime.datatype.unit.LUnit;

public class LUnitBangEquals extends LBinaryOperation<LUnit, LUnit, LUnit>
{
	public static final LUnitBangEquals instance = new LUnitBangEquals();

	private LUnitBangEquals()
	{
		super(LBinaryOperator.BANG_EQUALS);
	}

	@Override
	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		return LBoolean.valueOf(!leftOperand._equals(rightOperand));
	}
}
