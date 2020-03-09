package loki.runtime.unit.number.member.operation.unary;

import loki.runtime.unit.member.operation.LUnaryOperation;
import loki.runtime.unit.number.LNumber;
import loki.runtime.LType;

public abstract class LNumberUnaryOperation extends LUnaryOperation<LNumber>
{
	protected LNumberUnaryOperation(LType type)
	{
		super(type, LNumber.TYPE);
	}
}
