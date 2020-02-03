package loki.runtime.datatype.unit.member;

import loki.runtime.datatype.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.type.LType;
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
