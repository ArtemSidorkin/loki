package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.LType;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.member.operation.LBinaryOperation;

public abstract class LNumberBinaryOperation extends LBinaryOperation<LNumber, LNumber>
{
	protected LNumberBinaryOperation(LType type)
	{
		super(type, LNumber.DESCRIPTOR.getType(), LNumber.DESCRIPTOR.getType());
	}
}
