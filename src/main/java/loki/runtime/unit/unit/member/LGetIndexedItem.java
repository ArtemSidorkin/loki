package loki.runtime.unit.unit.member;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LGetIndexedItem extends LMember
{
	public static final String TYPE_NAME = "getIndexedItem";
	public static final LType TYPE = new LType(TYPE_NAME, LGetIndexedItem.class);

	public static final LGetIndexedItem instance = new LGetIndexedItem();

	private LGetIndexedItem()
	{
		super(TYPE);
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		return host._getIndexedItem(parameters);
	}
}
