package loki.runtime.datatype.type.member.internal;

import loki.runtime.datatype.LUnit;

public abstract class LTypeInternalMember
{
	public abstract LUnit apply(String name, long id, LUnit[] parameters);
}
