package loki.runtime.builtins.operations.binary.number;

import loki.runtime.builtins.operations.binary.LBinaryOperation;
import loki.runtime.constant.LBinaryOperator;
import loki.runtime.constant.LTypes;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.number.LNumberPrototype;

public abstract class LNumberOperation extends LBinaryOperation<LNumberPrototype, LNumber, LNumber>
{
	protected LNumberOperation(LBinaryOperator operator)
	{
		super(operator, LTypes.NUMBER, LTypes.NUMBER);
	}
}
