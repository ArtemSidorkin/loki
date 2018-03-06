package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.builtins.operations.binary.LBinaryOperation;
import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.constant.LTypes;
import cloki.runtime.datatype.number.LNumber;
import cloki.runtime.datatype.number.LNumberPrototype;

public abstract class LNumberOperation extends LBinaryOperation<LNumberPrototype, LNumber, LNumber>
{
	protected LNumberOperation(LBinaryOperator operator)
	{
		super(operator, LTypes.NUMBER, LTypes.NUMBER);
	}
}
