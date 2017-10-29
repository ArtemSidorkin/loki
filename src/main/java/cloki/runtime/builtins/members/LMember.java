package cloki.runtime.builtins.members;

import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;

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
