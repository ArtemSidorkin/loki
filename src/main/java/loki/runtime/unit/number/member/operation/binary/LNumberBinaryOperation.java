package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.constant.LTypes;
import loki.runtime.unit.member.operation.LBinaryOperation;
import loki.runtime.unit.number.LNumber;

public abstract class LNumberBinaryOperation extends LBinaryOperation<LNumber, LNumber>
{
	protected LNumberBinaryOperation(LBinaryOperator operator)
	{
		super(operator, LTypes.NUMBER, LTypes.NUMBER);
	}
}
