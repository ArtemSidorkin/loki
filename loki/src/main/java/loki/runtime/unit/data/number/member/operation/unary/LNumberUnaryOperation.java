package loki.runtime.unit.data.number.member.operation.unary;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.member.operation.LUnaryOperation;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public abstract class LNumberUnaryOperation<OPERATION extends LUnit>
	extends LUnaryOperation<OPERATION, LNumber>
{
	protected LNumberUnaryOperation(LInstanceDescriptor<OPERATION> instanceUnitDescriptor)
	{
		super(instanceUnitDescriptor, LNumber.DESCRIPTOR);
	}
}
