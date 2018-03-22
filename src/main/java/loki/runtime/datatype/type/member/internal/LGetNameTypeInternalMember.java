package loki.runtime.datatype.type.member.internal;

import loki.runtime.datatype.LString;
import loki.runtime.datatype.LUnit;

public class LGetNameTypeInternalMember extends LTypeInternalMember
{
	public static final LGetNameTypeInternalMember instance = new LGetNameTypeInternalMember();

	@Override
	public LUnit apply(String name, long id, LUnit[] parameters)
	{
		return new LString(name);
	}
}
