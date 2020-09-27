package loki.runtime.unit.data.number.member.operation.binary;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.member.operation.LBinaryOperation;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public abstract class LNumberBinaryOperation<OPERATION extends LUnit>
	extends LBinaryOperation<OPERATION, LNumber, LNumber>
{
	protected LNumberBinaryOperation(LInstanceDescriptor<OPERATION> instanceDescriptor)
	{
		super(instanceDescriptor, LNumber.DESCRIPTOR, LNumber.DESCRIPTOR);
	}
}
