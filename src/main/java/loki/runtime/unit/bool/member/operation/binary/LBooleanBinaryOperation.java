package loki.runtime.unit.bool.member.operation.binary;

import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.member.operation.LBinaryOperation;
import loki.runtime.unit.type.LType;

public abstract class LBooleanBinaryOperation extends LBinaryOperation<LBoolean, LBoolean>
{
	protected LBooleanBinaryOperation(LType type)
	{
		super(type, LBoolean.TYPE, LBoolean.TYPE);
	}
}
