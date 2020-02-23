package loki.runtime.unit.bool.member.operation.unary;

import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.member.operation.LUnaryOperation;
import loki.runtime.unit.type.LType;

public abstract class LBooleanUnaryOperation extends LUnaryOperation<LBoolean>
{
	protected LBooleanUnaryOperation(LType type)
	{
		super(type, LBoolean.TYPE);
	}
}
