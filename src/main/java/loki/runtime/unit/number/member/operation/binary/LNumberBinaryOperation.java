package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.unit.member.operation.LBinaryOperation;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.type.LType;

public abstract class LNumberBinaryOperation extends LBinaryOperation<LNumber, LNumber>
{
	protected LNumberBinaryOperation(LType type)
	{
		super(type, LNumber.TYPE, LNumber.TYPE);
	}
}
