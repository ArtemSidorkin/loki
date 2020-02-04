package loki.runtime.unit.unit.member;

import loki.runtime.constant.LUnitMember;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.Nullable;

public class LSetIndexItem extends LMember
{
	public static final LSetIndexItem instance = new LSetIndexItem();

	private LSetIndexItem()
	{
		super(new LType(LUnitMember.SET_INDEXED_ITEM.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		return host._setIndexedItem(parameters);
	}
}
