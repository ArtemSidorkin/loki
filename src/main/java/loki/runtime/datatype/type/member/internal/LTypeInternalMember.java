package loki.runtime.datatype.type.member.internal;

import loki.runtime.datatype.unit.LUnit;

import java.util.Map;

public abstract class LTypeInternalMember
{
	private final String designation;

	protected LTypeInternalMember(String designation)
	{
		this.designation = designation;
	}

	public abstract LUnit apply(String name, long id, LUnit[] parameters);

	public void initialize(Map<String, LTypeInternalMember> internalMembers)
	{
		internalMembers.put(designation, this);
	}
}
