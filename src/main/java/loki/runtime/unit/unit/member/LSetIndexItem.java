package loki.runtime.unit.unit.member;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LSetIndexItem extends LMember
{
	public static final String TYPE_NAME = "setIndexedItem";
	public static final LType TYPE = new LType(TYPE_NAME, LSetIndexItem.class);

	public static final LSetIndexItem INSTANCE = new LSetIndexItem();

	private LSetIndexItem()
	{
		super(TYPE);
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return host._setIndexedItem(parameters);
	}
}
