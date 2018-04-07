package loki.runtime.datatype.number.member.internal;

import loki.runtime.datatype.unit.LUnit;

import java.util.Map;

public abstract class LNumberInternalMember
{
	private final String designation;

	protected LNumberInternalMember(String designation)
	{
		this.designation = designation;
	}

	public abstract LUnit apply(double value, LUnit[] parameters);

	public void initialize(Map<String, LNumberInternalMember> internalMembers)
	{
		internalMembers.put(designation, this);
	}
}
