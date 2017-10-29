package cloki.runtime.builtins.members.unit;

import cloki.runtime.builtins.members.CMember;
import cloki.runtime.consts.CConstUnitMember;
import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.Nullable;

public class CGetIndexItem extends CMember
{
	public static final CGetIndexItem instance = new CGetIndexItem();

	private CGetIndexItem()
	{
		super(new CType(CConstUnitMember.GET_INDEX_ITEM.name));
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		return host._getIndexedItem(parameters);
	}
}
