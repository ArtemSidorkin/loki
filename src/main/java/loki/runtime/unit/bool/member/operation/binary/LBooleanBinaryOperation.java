package loki.runtime.unit.bool.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.constant.LTypes;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.member.operation.LBinaryOperation;

public abstract class LBooleanBinaryOperation extends LBinaryOperation<LBoolean, LBoolean>
{
	protected LBooleanBinaryOperation(LBinaryOperator operator)
	{
		super(operator, LTypes.BOOLEAN, LTypes.BOOLEAN);
	}
}
