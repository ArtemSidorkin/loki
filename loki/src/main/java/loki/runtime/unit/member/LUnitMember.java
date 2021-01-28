package loki.runtime.unit.member;

import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public abstract class LUnitMember<MEMBER extends LUnit> extends LUnit
{
	protected LUnitMember(LInstanceDescriptor<MEMBER> instanceDescriptor)
	{
		super(instanceDescriptor);
	}
}
