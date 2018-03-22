package loki.runtime.builtin.member.unit;

import loki.runtime.builtin.member.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LUnit;
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
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return host._getIndexedItem(parameters);
	}
}
