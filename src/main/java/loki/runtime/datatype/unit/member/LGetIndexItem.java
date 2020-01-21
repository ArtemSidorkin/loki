package loki.runtime.datatype.unit.member;

import loki.runtime.datatype.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.type.LType;
import loki.runtime.util.Nullable;

public class LGetIndexItem extends LMember
{
	public static final LGetIndexItem instance = new LGetIndexItem();

	private LGetIndexItem()
	{
		super(new LType(LUnitMember.GET_INDEX_ITEM.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		return host._getIndexedItem(parameters);
	}
}
