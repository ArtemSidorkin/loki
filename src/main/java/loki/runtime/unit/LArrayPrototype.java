package loki.runtime.unit;

import loki.runtime.constant.LTypes;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;
import loki.runtime.util.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class LArrayPrototype extends LUnit
{
	public static final LArrayPrototype instance = new LArrayPrototype();

	@Nullable protected final ArrayList<LUnit> items;

	public LArrayPrototype(LUnit[] items)
	{
		super(LTypes.ARRAY);
		this.items = items != null ? new ArrayList<>(Arrays.asList(items)) : null;
	}

	private LArrayPrototype()
	{
		super(LTypes.ARRAY_PROTOTYPE);
		items = null;
	}

	@Override
	public LUnit _getIndexedItem(@Nullable LUnit[] parameters)
	{
		LUnit indexAsUnit = checkCallParameter(parameters, 0);
		LNumber indexAsNumber = indexAsUnit.asType(LTypes.NUMBER);

		if (indexAsNumber == null)
		{
			LErrors.unitDoesNotBelongToType(indexAsUnit, LTypes.NUMBER.getFullName());

			return LUndefined.instance;
		}

		int index = (int)indexAsNumber.value;

		if (items != null && index >= 0 && index < items.size()) return items.get(index);

		LErrors.itemWithIndexDoesNotExist(index);
		return LUndefined.instance;
	}

	@Override
	public LUnit _setIndexedItem(@Nullable LUnit[] parameters)
	{
		LUnit indexAsUnit = checkCallParameter(parameters, 0);
		LNumber indexAsNumber = indexAsUnit.asType(LTypes.NUMBER);

		if (indexAsNumber == null)
		{
			LErrors.unitDoesNotBelongToType(indexAsUnit, LTypes.NUMBER.getFullName());

			return LUndefined.instance;
		}

		int index = (int)indexAsNumber.value;

		if (items != null && index >= 0)
		{
			LUnit item = checkCallParameter(parameters, 1);

			while (index > items.size()) items.add(LUndefined.instance);

			if (index == items.size()) items.add(item);
			else items.set(index, item);

			return item;
		}

		LErrors.itemWithIndexDoesNotExist(index);
		return LUndefined.instance;
	}

	@Override
	public LString _toString()
	{
		if (items == null || items.size() == 0) return new LString("[]");

		StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

		for (LUnit item : items) stringJoiner.add(item.toString());

		return new LString(stringJoiner.toString());
	}
}
