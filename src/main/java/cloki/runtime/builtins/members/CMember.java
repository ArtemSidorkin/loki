package cloki.runtime.builtins.members;

import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;

public class CMember extends LUnit
{
	private String name;

	protected CMember(LType type)
	{
		super(type);
		name = type.getName();
	}

	public void init(LUnit unit)
	{
		unit.setMember(name, this);
	}
}
