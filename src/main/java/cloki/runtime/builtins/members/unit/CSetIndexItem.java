package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.constant.LUnitMember;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

public class CSetIndexItem extends CMember
{
	public static final CSetIndexItem instance = new CSetIndexItem();

	private CSetIndexItem()
	{
		super(new LType(LUnitMember.SET_INDEX_ITEM.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return host._setIndexedItem(parameters);
	}
}
