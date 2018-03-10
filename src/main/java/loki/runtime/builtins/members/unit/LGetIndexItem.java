package loki.runtime.builtins.members.unit;

import loki.runtime.builtins.members.LMember;
import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LType;
import loki.runtime.datatype.LUnit;
import loki.runtime.utils.Nullable;

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
