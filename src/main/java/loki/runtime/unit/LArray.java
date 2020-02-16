package loki.runtime.unit;

import loki.runtime.constant.LTypes;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class LArray extends LUnit
{
	public static final LArray PROTOTYPE = new LArray();

	private final ArrayList<LUnit> items = new ArrayList<>();

	public LArray(LUnit[] items)
	{
		super(LTypes.ARRAY);

		_addParents(PROTOTYPE);

		this.items.addAll(Arrays.asList(items));
	}

	private LArray()
	{
		super(LTypes.ARRAY_PROTOTYPE);
	}

	@Override
	public LUnit _getIndexedItem(LUnit[] parameters)
	{
		int index = getIndexFromCallParameters(parameters);

		return index >= 0 && index < items.size() ? items.get(index) : LVoid.INSTANCE;
	}

	@Override
	public LUnit _setIndexedItem(LUnit[] parameters)
	{
		int index = getIndexFromCallParameters(parameters);

		if (index < 0 || index >= items.size()) LErrors.itemWithIndexDoesNotExist(index);

		LUnit item = checkCallParameter(parameters, 1);

		items.set(index, item);

		return item;
	}

	@Override
	public LNumber _hashCode()
	{
		return new LNumber(items.hashCode());
	}

	@Override
	public LBoolean _equals(LUnit unit)
	{
		LArray array = unit.asType(LTypes.ARRAY);

		return array != null ? LBoolean.valueOf(items.equals(array.items)) : LBoolean.FALSE;
	}

	@Override
	public LString _toString()
	{
		if (items.size() == 0) return new LString("[]");

		StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

		for (LUnit item : items) stringJoiner.add(item.toString());

		return new LString(stringJoiner.toString());
	}

	private int getIndexFromCallParameters(LUnit[] parameters)
	{
		LUnit unitIndex = checkCallParameter(parameters, 0);
		LNumber numberIndex = unitIndex.asType(LTypes.NUMBER);

		if (numberIndex == null) LErrors.unitDoesNotBelongToType(unitIndex, LTypes.NUMBER.getFullName());

		int index = (int)numberIndex.getValue();

		if (index < 0) index = items.size() - Math.abs(index);

		return index;
	}
}
