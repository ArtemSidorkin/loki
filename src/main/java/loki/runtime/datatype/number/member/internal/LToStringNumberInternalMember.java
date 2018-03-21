package loki.runtime.datatype.number.member.internal;

import loki.runtime.datatype.LString;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.member.operation.internal.LNumberInternalOperation;

public class LToStringNumberInternalMember extends LNumberInternalOperation
{
	public static final LToStringNumberInternalMember instance = new LToStringNumberInternalMember();

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		return new LString(value == Math.floor(value) ? String.valueOf((long)value) : String.valueOf(value));
	}
}
