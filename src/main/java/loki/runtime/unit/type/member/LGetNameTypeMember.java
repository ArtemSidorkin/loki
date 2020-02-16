package loki.runtime.unit.type.member;

import loki.runtime.constant.LTypeMember;
import loki.runtime.unit.LString;
import loki.runtime.unit.LVoid;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;

public class LGetNameTypeMember extends LMember
{
	public static LGetNameTypeMember instance = new LGetNameTypeMember();

	private LGetNameTypeMember()
	{
		super(new LType(LTypeMember.GET_NAME.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		if (host instanceof LType) return new LString(((LType)host).getName());

		LErrors
			.unitDoesNotBelongToType(
				host, LType.makeFullName(loki.runtime.constant.LType.TYPE.name, LType.META_TYPE_ID)
			);

		return LVoid.INSTANCE;
	}
}
