package loki.runtime.unit.data.bool.member.operation.binary;

import loki.runtime.LType;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.member.operation.LBinaryOperation;

public abstract class LBooleanBinaryOperation extends LBinaryOperation<LBoolean, LBoolean>
{
	protected LBooleanBinaryOperation(LType type)
	{
		super(type, LBoolean.DESCRIPTOR.getType(), LBoolean.DESCRIPTOR.getType());
	}
}
