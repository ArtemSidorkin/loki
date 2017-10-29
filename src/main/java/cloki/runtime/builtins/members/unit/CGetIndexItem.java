package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.constant.LUnitMember;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

public class CGetIndexItem extends CMember
{
	public static final CGetIndexItem instance = new CGetIndexItem();

	private CGetIndexItem()
	{
		super(new LType(LUnitMember.GET_INDEX_ITEM.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return host._getIndexedItem(parameters);
	}
}
