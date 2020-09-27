package loki.runtime.unit.data.bool.member.operation.binary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.member.operation.LBinaryOperation;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public abstract class LBooleanBinaryOperation<OPERATION extends LUnit>
	extends LBinaryOperation<OPERATION, LBoolean, LBoolean>
{
	protected LBooleanBinaryOperation(LInstanceDescriptor<OPERATION> instanceDescriptor)
	{
		super(instanceDescriptor, LBoolean.DESCRIPTOR, LBoolean.DESCRIPTOR);
	}
}
