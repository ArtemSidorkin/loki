package loki.runtime.unit.unit.member;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LGetIndexItem extends LMember
{
	public static final String TYPE_NAME = "getIndexedItem";
	public static final LType TYPE = new LType(TYPE_NAME, LGetIndexItem.class);

	public static final LGetIndexItem instance = new LGetIndexItem();

	private LGetIndexItem()
	{
		super(TYPE);
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return host._getIndexedItem(parameters);
	}
}
