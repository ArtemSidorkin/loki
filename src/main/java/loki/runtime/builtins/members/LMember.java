package loki.runtime.builtins.members;

import loki.runtime.datatype.LType;
import loki.runtime.datatype.LUnit;

public class LMember extends LUnit
{
	private String name;

	protected LMember(LType type)
	{
		super(type);
		name = type.getName();
	}

	public void init(LUnit unit)
	{
		unit.setMember(name, this);
	}
}
