package loki.runtime.builtin.operation.binary.bool;

import loki.runtime.builtin.operation.binary.LBinaryOperation;
import loki.runtime.constant.LBinaryOperator;
import loki.runtime.constant.LTypes;
import loki.runtime.datatype.LBoolean;

public abstract class LBooleanOperation extends LBinaryOperation<LBoolean, LBoolean, LBoolean>
{
	protected LBooleanOperation(LBinaryOperator operator)
	{
		super(operator, LTypes.BOOLEAN, LTypes.BOOLEAN);
	}
}
