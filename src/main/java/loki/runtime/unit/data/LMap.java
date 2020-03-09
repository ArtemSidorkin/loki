package loki.runtime.unit.data;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LDataUnitDescriptor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public class LMap extends LUnit
{
	public static final LDataUnitDescriptor<LMap> DESCRIPTOR =
		new LDataUnitDescriptor<>("Map", "MapPrototype", LMap.class);

	private final Map<LUnit, LUnit> items = new LinkedHashMap<>();

	public LMap(LUnit[] items)
	{
		super(DESCRIPTOR.getType());

		_addParents(DESCRIPTOR.getPrototype());

		for (int i = 0; i < items.length; i += 2) this.items.put(items[i], items[i + 1]);
	}

	private LMap()
	{
		super(DESCRIPTOR.getPrototypeType());
	}

	@Override
	public LUnit _getIndexedItem(LUnit[] parameters)
	{
		LUnit key = checkCallParameter(parameters, 0);
		LUnit item = items.get(key);

		return item != null ? item : LVoid.DESCRIPTOR.getInstance();
	}

	@Override
	public LUnit _setIndexedItem(LUnit[] parameters)
	{
		LUnit key = checkCallParameter(parameters, 0);
		LUnit value = checkCallParameter(parameters, 1);

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
		LMap map = unit.asType(DESCRIPTOR.getType());

		return map != null ? LBoolean.valueOf(items.equals(map.items)) : LBoolean.FALSE;
	}

	@Override
	public LString _toString()
	{
		if (items.size() == 0) return new LString("[:]");

		StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

		for (LUnit key : items.keySet()) stringJoiner.add(String.format("%s : %s", key, items.get(key)));

		return new LString(stringJoiner.toString());
	}
}
