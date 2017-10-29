package cloki.runtime.datatypes;

import cloki.runtime.consts.CConstTypes;
import cloki.runtime.utils.CErrors;
import cloki.runtime.utils.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class CArrayPrototype extends CUnit
{
	public static final CArrayPrototype instance = new CArrayPrototype();

	@Nullable protected final ArrayList<CUnit> items;

	public CArrayPrototype(CUnit[] items)
	{
		super(CConstTypes.ARRAY);
		this.items = items != null ? new ArrayList<>(Arrays.asList(items)) : null;
	}

	private CArrayPrototype()
	{
		super(CConstTypes.ARRAY_PROTOTYPE);
		items = null;
	}

	@Override
	public CUnit _getIndexedItem(@Nullable CUnit[] parameters)
	{
		CUnit indxAsUnt = checkCallParameter(parameters, 0);
		CNumber indxAsNmbr = indxAsUnt.asType(CConstTypes.NUMBER);

		if (indxAsNmbr == null)
		{
			CErrors.printErrorUnitDoesNotBelongToType(indxAsUnt, CConstTypes.NUMBER.getName());
			return CUndefined.instance;
		}

		int indx = (int)indxAsNmbr.getValue();

		if (items != null && indx >= 0 && indx < items.size()) return items.get(indx);

		CErrors.printErrorItemWithIndexDoesNotExist(indx);
		return CUndefined.instance;
	}

	@Override
	public CUnit _setIndexedItem(@Nullable CUnit[] parameters)
	{
		CUnit indxAsUnt = checkCallParameter(parameters, 0);
		CNumber indxAsNmbr = indxAsUnt.asType(CConstTypes.NUMBER);

		if (indxAsNmbr == null)
		{
			CErrors.printErrorUnitDoesNotBelongToType(indxAsUnt, CConstTypes.NUMBER.getName());
			return CUndefined.instance;
		}

		int indx = (int)indxAsNmbr.getValue();

		if (items != null && indx >= 0)
		{
			CUnit itm = checkCallParameter(parameters, 1);
			while (indx > items.size()) items.add(CUndefined.instance);
			if (indx == items.size()) items.add(itm);
			else items.set(indx, itm);
			return itm;
		}

		CErrors.printErrorItemWithIndexDoesNotExist(indx);
		return CUndefined.instance;
	}
}
