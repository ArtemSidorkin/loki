package loki.runtime.unit.type.member;

import loki.runtime.constant.LTypeMember;
import loki.runtime.unit.LVoid;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;

public class LGetIdTypeMember extends LMember
{
	public static LGetIdTypeMember instance = new LGetIdTypeMember();

	private LGetIdTypeMember()
	{
		super(new LType(LTypeMember.GET_ID.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		if (host instanceof LType) return new LNumber(((LType)host).getId());

		LErrors
			.unitDoesNotBelongToType(
				host, LType.makeFullName(loki.runtime.constant.LType.TYPE.name, LType.META_TYPE_ID)
			);

		return LVoid.INSTANCE;
	}
}
