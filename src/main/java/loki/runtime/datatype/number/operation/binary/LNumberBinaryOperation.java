package loki.runtime.datatype.number.operation.binary;

import loki.runtime.builtin.operation.binary.LBinaryOperation;
import loki.runtime.constant.LBinaryOperator;
import loki.runtime.constant.LTypes;
import loki.runtime.datatype.number.LNumber;

public abstract class LNumberBinaryOperation extends LBinaryOperation<LNumber, LNumber, LNumber>
{
	protected LNumberBinaryOperation(LBinaryOperator operator)
	{
		super(operator, LTypes.NUMBER, LTypes.NUMBER);
	}
}
