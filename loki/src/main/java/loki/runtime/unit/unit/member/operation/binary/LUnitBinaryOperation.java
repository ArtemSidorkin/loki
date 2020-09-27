package loki.runtime.unit.unit.member.operation.binary;

import loki.runtime.unit.member.operation.LBinaryOperation;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public abstract class LUnitBinaryOperation<OPERATION extends LUnit> extends LBinaryOperation<OPERATION, LUnit, LUnit>
{
	protected LUnitBinaryOperation(LInstanceDescriptor<OPERATION> instanceDescriptor)
	{
		super(instanceDescriptor);
	}
}
