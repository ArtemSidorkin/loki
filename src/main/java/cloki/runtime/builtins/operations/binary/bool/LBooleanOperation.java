package cloki.runtime.builtins.operations.binary.bool;

import cloki.runtime.builtins.operations.binary.LBinaryOperation;
import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.constant.LTypes;
import cloki.runtime.datatype.LBoolean;
import cloki.runtime.datatype.LBooleanPrototype;

public abstract class LBooleanOperation extends LBinaryOperation<LBooleanPrototype, LBoolean, LBoolean>
{
	protected LBooleanOperation(LBinaryOperator operator)
	{
		super(operator, LTypes.BOOLEAN, LTypes.BOOLEAN);
	}
}
