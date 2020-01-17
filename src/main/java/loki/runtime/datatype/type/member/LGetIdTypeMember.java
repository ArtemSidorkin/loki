package loki.runtime.datatype.type.member;

import loki.runtime.datatype.LMember;
import loki.runtime.constant.LTypeMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.type.LType;
import loki.runtime.util.LErrors;
import loki.runtime.util.Nullable;

public class LGetIdTypeMember extends LMember
{
	public static LGetIdTypeMember instance = new LGetIdTypeMember();

	private LGetIdTypeMember()
	{
		super(new LType(LTypeMember.GET_ID.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		if (host instanceof LType) return new LNumber(((LType)host).id);

		LErrors.unitDoesNotBelongToType(host, loki.runtime.constant.LType.TYPE.name);
		return LUndefined.instance;
	}
}
