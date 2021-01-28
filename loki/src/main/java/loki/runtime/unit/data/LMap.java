package loki.runtime.unit.data;

import loki.runtime.marker.Compiler;
import loki.runtime.marker.Prototype;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unit.unit.member.operation.binary.LEquality;
import loki.runtime.unitdescriptor.LPrototypeDescriptor;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static loki.runtime.error.LErrors.operandHasWrongType;
import static loki.runtime.unit.member.operation.LOperandPosition.RIGHT;

public class LMap extends LUnit
{
	public static final LPrototypeDescriptor<LMap> DESCRIPTOR =
		new LPrototypeDescriptor<>("Map", "MapPrototype", LMap.class, LMap::new);

	private static final int PROTOTYPE_ITEMS_INITIAL_CAPACITY = 0;

	private static final int KEY_PARAMETER_INDEX = 0;
	private static final int VALUE_PARAMETER_INDEX = 1;

	private final Map<LUnit, LUnit> items;

	@Compiler
	public LMap(LUnit[] items)
	{
		super(DESCRIPTOR);

		this.items = new LinkedHashMap<>();

		_addParents(DESCRIPTOR.getPrototype());

		for (int i = 0; i < items.length; i += 2) this.items.put(items[i], items[i + 1]);
	}

	@Prototype
	private LMap()
	{
		super(DESCRIPTOR.getPrototypeType());

		items = new LinkedHashMap<>(PROTOTYPE_ITEMS_INITIAL_CAPACITY);
	}

	@Override
	public LUnit _getIndexedItem(LUnit[] parameters)
	{
		LUnit key = getParameter(parameters, KEY_PARAMETER_INDEX);
		LUnit value = items.get(key);

		return value != null ? value : LVoid.getInstance();
	}

	@Override
	public LUnit _setIndexedItem(LUnit[] parameters)
	{
		LUnit key = getParameter(parameters, KEY_PARAMETER_INDEX);
		LUnit value = getParameter(parameters, VALUE_PARAMETER_INDEX);

		items.put(key, value);

		return value;
	}

	@Override
	public LNumber _hashCode()
	{
		return new LNumber(items.hashCode());
	}

	@Override
	public LBoolean _equals(LUnit unit)
	{
		Map<LUnit, LUnit> value = unit.asType(DESCRIPTOR, operandHasWrongType(this, LEquality.DESCRIPTOR, RIGHT)).items;

		return LBoolean.valueOf(items.equals(value));
	}

	@Override
	public LString _toString()
	{
		if (items.size() == 0) return new LString("[:]");

		String value =
			items
				.entrySet()
				.stream()
				.map(key -> String.format("%s : %s", key.getKey(), key.getValue()))
				.collect(Collectors.joining(", ", "[", "]"));

		return new LString(value);
	}
}
