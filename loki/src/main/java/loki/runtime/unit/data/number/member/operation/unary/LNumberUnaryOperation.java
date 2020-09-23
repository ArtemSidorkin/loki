package loki.runtime.unit.data.number.member.operation.unary;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.member.operation.LUnaryOperation;
import loki.runtime.unitdescriptor.LUnitDescriptor;

public abstract class LNumberUnaryOperation extends LUnaryOperation<LNumber>
{
	protected LNumberUnaryOperation(LUnitDescriptor<LNumber> unitDescriptor)
	{
		super(unitDescriptor, LNumber.DESCRIPTOR);
	}
}
