package loki.runtime.builtin.member;

import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.type.LType;

public class LMember extends LUnit
{
	private String name;

	protected LMember(LType type)
	{
		super(type);
		name = type.name;
	}

	public void init(LUnit unit)
	{
		unit.setMember(name, this);
	}
}
