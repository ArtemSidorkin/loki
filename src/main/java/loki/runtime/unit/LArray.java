package loki.runtime.unit;

import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.LNumber;
import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class LArray extends LUnit
{
	public static final String TYPE_NAME = "Array";
	public static final LType TYPE = new LType(TYPE_NAME, LArray.class);

	public static final String PROTOTYPE_NAME = "ArrayPrototype";
	public static final LType PROTO_TYPE = new LType(PROTOTYPE_NAME, LArray.class);
	public static final LArray PROTOTYPE = new LArray();

	private final ArrayList<LUnit> items = new ArrayList<>();

	public LArray(LUnit[] items)
	{
		super(TYPE);

		_addParents(PROTOTYPE);

		this.items.addAll(Arrays.asList(items));
	}

	private LArray()
	{
		super(PROTO_TYPE);
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

		if (index < 0 || index >= items.size()) LErrors.UnitDoesNotHaveItemWithIndex(this, parameters[0]);

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
		LArray array = unit.asType(TYPE);

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
		LNumber numberIndex = unitIndex.asType(LNumber.TYPE);

		if (numberIndex == null) LErrors.operandShouldHaveType(unitIndex, LNumber.TYPE);

		int index = (int)numberIndex.getValue();

		if (index < 0) index = items.size() - Math.abs(index);

		return index;
	}
}
