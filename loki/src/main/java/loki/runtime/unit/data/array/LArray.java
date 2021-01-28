package loki.runtime.unit.data.array;

import loki.runtime.error.LErrors;
import loki.runtime.marker.Compiler;
import loki.runtime.marker.Prototype;
import loki.runtime.unit.data.LString;
import loki.runtime.unit.data.array.member.LFilter;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.member.operation.LOperandPosition;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unit.unit.member.method.LGetIndexedItem;
import loki.runtime.unit.unit.member.method.LSetIndexedItem;
import loki.runtime.unit.unit.member.operation.binary.LEquality;
import loki.runtime.unitdescriptor.LPrototypeDescriptor;
import loki.runtime.unitdescriptor.LUnitDescriptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static loki.runtime.error.LErrors.methodParameterHasWrongType;
import static loki.runtime.error.LErrors.unitHasNoIndexedItem;

public class LArray extends LUnit
{
	public static final LPrototypeDescriptor<LArray> DESCRIPTOR =
		new LPrototypeDescriptor<>("Array", "ArrayPrototype", LArray.class, LArray::new);

	private static final int PROTOTYPE_ITEMS_INITIAL_CAPACITY = 0;

	private static final int INDEX_PARAMETER_INDEX = 0;

	private final ArrayList<LUnit> items;

	@Compiler
	public LArray(LUnit[] items)
	{
		super(DESCRIPTOR.getUnitType());

		_addParents(DESCRIPTOR.getPrototype());

		this.items = new ArrayList<>(Arrays.asList(items));
	}

	public LArray(ArrayList<LUnit> items)
	{
		super(DESCRIPTOR.getUnitType());

		_addParents(DESCRIPTOR.getPrototype());

		this.items = items;
	}

	@Prototype
	private LArray()
	{
		super(DESCRIPTOR.getPrototypeType());

		items = new ArrayList<>(PROTOTYPE_ITEMS_INITIAL_CAPACITY);

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

		return items.get(index);
	}

	@Override
	public LUnit _setIndexedItem(LUnit[] parameters)
	{
		int index = getIndexFromCallParameters(parameters, LSetIndexedItem.DESCRIPTOR);

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
	public LBoolean _equals(LUnit otherUnit)
	{
		LArray array =
			otherUnit
				.asType(DESCRIPTOR, LErrors.operandHasWrongType(this, LEquality.DESCRIPTOR, LOperandPosition.RIGHT));

		return LBoolean.valueOf(items.equals(array.items));
	}

	@Override
	public LString _toString()
	{
		if (items.size() == 0) return new LString("[]");

		String value = items.stream().map(LUnit::toString).collect(Collectors.joining(", ", "[", "]"));

		return new LString(value);
	}

	private int getIndexFromCallParameters(LUnit[] parameters, LUnitDescriptor<?> methodDescriptor)
	{
		int index =
			getParameter(parameters, INDEX_PARAMETER_INDEX)
				.asType(LNumber.DESCRIPTOR, methodParameterHasWrongType(this, methodDescriptor, INDEX_PARAMETER_INDEX))
				.intValue();

		if (index < 0) index = items.size() - Math.abs(index);

		if (index < 0 || index >= items.size()) unitHasNoIndexedItem(this, parameters[INDEX_PARAMETER_INDEX]);

		return index;
	}

	private void initBuiltins()
	{
		addMember(LFilter.DESCRIPTOR);
	}
}
