package loki.runtime.unit.data.bool.member.operation.unary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.member.operation.LUnaryOperation;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public abstract class LBooleanUnaryOperation<OPERATION extends LUnit> extends LUnaryOperation<OPERATION, LBoolean>
{
	protected LBooleanUnaryOperation(LInstanceDescriptor<OPERATION> instanceDescriptor)
	{
		super(instanceDescriptor, LBoolean.DESCRIPTOR);
	}
}
