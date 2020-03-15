package loki.runtime.unit.data.number.member.operation.unary;

import loki.runtime.LType;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.member.operation.LUnaryOperation;

public abstract class LNumberUnaryOperation extends LUnaryOperation<LNumber>
{
	protected LNumberUnaryOperation(LType type)
	{
		super(type, LNumber.DESCRIPTOR.getType());
	}
}
