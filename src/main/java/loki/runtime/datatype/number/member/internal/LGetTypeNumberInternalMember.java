package loki.runtime.datatype.number.member.internal;

import loki.runtime.constant.LTypes;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.member.operation.internal.LNumberInternalOperation;

public class LGetTypeNumberInternalMember extends LNumberInternalOperation
{
	public static final LGetTypeNumberInternalMember instance = new LGetTypeNumberInternalMember();

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		return LTypes.NUMBER_PROTOTYPE;
	}
}
