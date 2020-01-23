package loki.runtime.datatype;

import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.type.LType;

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
