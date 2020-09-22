package loki.runtime.unit.data.bool.member.operation.unary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.member.operation.LUnaryOperation;
import loki.runtime.unitdescriptor.LTypeUnitDescriptor;

public abstract class LBooleanUnaryOperation extends LUnaryOperation<LBoolean>
{
	protected LBooleanUnaryOperation(LTypeUnitDescriptor typeDescriptor)
	{
		super(typeDescriptor, LBoolean.DESCRIPTOR);
	}
}
