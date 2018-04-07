package loki.runtime.datatype.number.member.internal;

import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnitMember;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.member.operation.internal.LNumberInternalOperation;

public class LGetTypeNumberInternalMember extends LNumberInternalOperation
{
	public static final LGetTypeNumberInternalMember instance = new LGetTypeNumberInternalMember();

	private LGetTypeNumberInternalMember()
	{
		super(LUnitMember.GET_TYPE.name);
	}

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		return LTypes.NUMBER_PROTOTYPE;
	}
}
