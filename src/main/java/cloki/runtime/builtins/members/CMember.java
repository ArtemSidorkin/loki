package cloki.runtime.builtins.members;

import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUnit;

public class CMember extends CUnit
{
	private String name;

	protected CMember(CType type)
	{
		super(type);
		name = type.getName();
	}

	public void init(CUnit unit)
	{
		unit.setMember(name, this);
	}
}
