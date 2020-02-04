package loki.runtime.unit.bool.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.member.operation.LBinaryOperation;
import loki.runtime.unit.unit.LUnit;

public abstract class LBooleanOperation extends LBinaryOperation<LUnit, LUnit>
{
	protected LBooleanOperation(LBinaryOperator operator)
	{
		super(operator);
	}

	@Override
	protected LUnit _execute(LUnit leftOperand, LUnit rightOperand)
	{
		return LBoolean.valueOf(__execute(leftOperand.toBoolean(), rightOperand.toBoolean()));
	}

	protected abstract boolean __execute(boolean leftOperand, boolean rightOperand);
}
