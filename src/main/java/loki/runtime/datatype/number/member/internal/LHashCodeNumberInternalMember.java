package loki.runtime.datatype.number.member.internal;

import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.number.member.operation.internal.LNumberInternalOperation;

public class LHashCodeNumberInternalMember extends LNumberInternalOperation
{
	public static final LHashCodeNumberInternalMember instance = new LHashCodeNumberInternalMember();

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		return new LNumber(Double.hashCode(value));
	}
}
