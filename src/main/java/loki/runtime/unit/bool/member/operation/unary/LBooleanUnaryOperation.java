package loki.runtime.unit.bool.member.operation.unary;

import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.member.operation.LUnaryOperation;

public abstract class LBooleanUnaryOperation extends LUnaryOperation<LBoolean>
{
	protected LBooleanUnaryOperation(LUnaryOperator unaryOperator)
	{
		super(unaryOperator, LTypes.BOOLEAN);
	}
}
