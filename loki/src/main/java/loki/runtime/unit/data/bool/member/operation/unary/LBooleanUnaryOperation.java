package loki.runtime.unit.data.bool.member.operation.unary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.member.operation.LUnaryOperation;
import loki.runtime.unitdescriptor.LUnitDescriptor;

public abstract class LBooleanUnaryOperation extends LUnaryOperation<LBoolean>
{
	protected LBooleanUnaryOperation(LUnitDescriptor<?> unitDescriptor)
	{
		super(unitDescriptor, LBoolean.DESCRIPTOR);
	}
}
