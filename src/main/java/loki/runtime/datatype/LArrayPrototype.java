package loki.runtime.datatype;

import loki.runtime.constant.LTypes;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.unit.LUnit;
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
			LErrors.printErrorUnitDoesNotBelongToType(indexAsUnit, LTypes.NUMBER.name);
			return LUndefined.instance;
		}

		int index = (int)indexAsNumber.value;

		if (items != null && index >= 0 && index < items.size()) return items.get(index);

		LErrors.printErrorItemWithIndexDoesNotExist(index);
		return LUndefined.instance;
	}

	@Override
	public LUnit _setIndexedItem(@Nullable LUnit[] parameters)
	{
		LUnit indexAsUnit = checkCallParameter(parameters, 0);
		LNumber indexAsNumber = indexAsUnit.asType(LTypes.NUMBER);

		if (indexAsNumber == null)
		{
			LErrors.printErrorUnitDoesNotBelongToType(indexAsUnit, LTypes.NUMBER.name);
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

		LErrors.printErrorItemWithIndexDoesNotExist(index);
		return LUndefined.instance;
	}

	@Override
	public String _toString()
	{
		if (items == null || items.size() == 0) return "[]";

		StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

		for (LUnit item : items) stringJoiner.add(item.toString());

		return stringJoiner.toString();
	}
}
