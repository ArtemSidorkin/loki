package loki.runtime.datatype.number.member.operation.binary;

import loki.runtime.builtin.operation.binary.LBinaryOperation;
import loki.runtime.constant.LBinaryOperator;
import loki.runtime.constant.LTypes;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.number.LNumberPrototype;

public abstract class LNumberBinaryOperation extends LBinaryOperation<LNumberPrototype, LNumber, LNumber>
{
	protected LNumberBinaryOperation(LBinaryOperator operator)
	{
		super(operator, LTypes.NUMBER, LTypes.NUMBER);
	}
}
