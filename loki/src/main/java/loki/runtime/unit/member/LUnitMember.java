package loki.runtime.unit.member;

import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LUnitMember<UNIT_MEMBER extends LUnit> extends LUnit
{
	protected LUnitMember(LInstanceDescriptor<UNIT_MEMBER> instanceDescriptor)
	{
		super(instanceDescriptor);
	}
}
