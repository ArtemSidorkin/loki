package loki.runtime.unit.data.array;

import loki.runtime.unit.data.LString;
import loki.runtime.unit.data.array.member.LFilter;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unit.unit.member.LGetIndexedItem;
import loki.runtime.unit.unit.member.LSetIndexedItem;
import loki.runtime.unitdescriptor.LDataUnitDescriptor;
import loki.runtime.unitdescriptor.LUnitDescriptor;
import loki.runtime.util.Compiler;
import loki.runtime.util.Prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

import static loki.runtime.error.LErrors.methodParameterHasWrongType;
import static loki.runtime.error.LErrors.unitHasNoIndexedItem;

public class LArray extends LUnit
{
	public static final LDataUnitDescriptor<LArray> DESCRIPTOR =
		new LDataUnitDescriptor<>("Array", "ArrayPrototype", LArray.class, LArray::new);

	private final ArrayList<LUnit> items;

	@Compiler
	public LArray(LUnit[] items)
	{
		super(DESCRIPTOR.getType());

		_addParents(DESCRIPTOR.getPrototype());

		this.items = new ArrayList<>(Arrays.asList(items));
	}

	public LArray(ArrayList<LUnit> items)
	{
		super(DESCRIPTOR.getType());

		_addParents(DESCRIPTOR.getPrototype());

		this.items = items;
	}

	@Prototype
	private LArray()
	{
		super(DESCRIPTOR.getPrototypeType());

		items = new ArrayList<>(0);

		initBuiltins();
	}

	public ArrayList<LUnit> getItems()
	{
		return items;
	}

	@Override
	public LUnit _getIndexedItem(LUnit[] parameters)
	{
		int index = getIndexFromCallParameters(parameters, LGetIndexedItem.DESCRIPTOR);

		return index >= 0 && index < items.size() ? items.get(index) : LVoid.DESCRIPTOR.getInstance();
	}

	@Override
	public LUnit _setIndexedItem(LUnit[] parameters)
	{
		int index = getIndexFromCallParameters(parameters, LSetIndexedItem.DESCRIPTOR);

		if (index < 0 || index >= items.size()) unitHasNoIndexedItem(this, parameters[0]);

		LUnit item = getParameter(parameters, 1);

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
		LArray array = unit.asType(DESCRIPTOR.getType());

		return array != null ? LBoolean.valueOf(items.equals(array.items)) : LBoolean.FALSE.getInstance();
	}

	@Override
	public LString _toString()
	{
		if (items.size() == 0) return new LString("[]");

		StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

		for (LUnit item : items) stringJoiner.add(item.toString());

		return new LString(stringJoiner.toString());
	}

	private int getIndexFromCallParameters(LUnit[] parameters, LUnitDescriptor methodDescriptor)
	{
		LUnit unitIndex = getParameter(parameters, 0);

		LNumber numberIndex =
			unitIndex.asType(LNumber.DESCRIPTOR, methodParameterHasWrongType(this, methodDescriptor, 0));

		int index = (int)numberIndex.getValue();

		if (index < 0) index = items.size() - Math.abs(index);

		return index;
	}

	private void initBuiltins()
	{
		addMember(LFilter.DESCRIPTOR);
	}
}
