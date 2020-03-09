package loki.runtime.unit.member;

import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;

public class LMember extends LUnit
{
	protected LMember(LType type)
	{
		super(type);
	}

	public void init(LUnit host)
	{
		host.setMember(getType().getName(), this);
	}
}
