package loki.runtime.unit.number.member.operation.unary;

import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnaryOperator;
import loki.runtime.unit.member.operation.LUnaryOperation;
import loki.runtime.unit.number.LNumber;

public abstract class LNumberUnaryOperation extends LUnaryOperation<LNumber>
{
	protected LNumberUnaryOperation(LUnaryOperator unaryOperator)
	{
		super(unaryOperator, LTypes.NUMBER);
	}
}
