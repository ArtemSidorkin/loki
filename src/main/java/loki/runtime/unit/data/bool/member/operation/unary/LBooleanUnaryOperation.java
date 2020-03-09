package loki.runtime.unit.data.bool.member.operation.unary;

import loki.runtime.LType;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.member.operation.LUnaryOperation;

public abstract class LBooleanUnaryOperation extends LUnaryOperation<LBoolean>
{
	protected LBooleanUnaryOperation(LType type)
	{
		super(type, LBoolean.DESCRIPTOR.getType());
	}
}
