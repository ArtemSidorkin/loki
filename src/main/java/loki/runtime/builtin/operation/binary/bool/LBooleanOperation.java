package loki.runtime.builtin.operation.binary.bool;

import loki.runtime.builtin.operation.binary.LBinaryOperation;
import loki.runtime.constant.LBinaryOperator;
import loki.runtime.constant.LTypes;
import loki.runtime.datatype.LBoolean;
import loki.runtime.datatype.LBooleanPrototype;

public abstract class LBooleanOperation extends LBinaryOperation<LBooleanPrototype, LBoolean, LBoolean>
{
	protected LBooleanOperation(LBinaryOperator operator)
	{
		super(operator, LTypes.BOOLEAN, LTypes.BOOLEAN);
	}
}
