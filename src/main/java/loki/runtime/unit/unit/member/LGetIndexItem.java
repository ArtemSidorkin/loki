package loki.runtime.unit.unit.member;

import loki.runtime.constant.LUnitMember;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.Nullable;

public class LGetIndexItem extends LMember
{
	public static final LGetIndexItem instance = new LGetIndexItem();

	private LGetIndexItem()
	{
		super(new LType(LUnitMember.GET_INDEXED_ITEM.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		return host._getIndexedItem(parameters);
	}
}
