package loki.runtime.unit.data;

import loki.runtime.marker.Compiler;
import loki.runtime.marker.Prototype;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LPrototypeDescriptor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public class LMap extends LUnit
{
	public static final LPrototypeDescriptor<LMap> DESCRIPTOR =
		new LPrototypeDescriptor<>("Map", "MapPrototype", LMap.class, LMap::new);

	private final Map<LUnit, LUnit> items = new LinkedHashMap<>();

	@Compiler
	public LMap(LUnit[] items)
	{
		super(DESCRIPTOR.getUnitType());

		_addParents(DESCRIPTOR.getPrototype());

		for (int i = 0; i < items.length; i += 2) this.items.put(items[i], items[i + 1]);
	}

	@Prototype
	private LMap()
	{
		super(DESCRIPTOR.getPrototypeType());
	}

	public Map<LUnit, LUnit> getItems()
	{
		return items;
	}

	@Override
	public LUnit _getIndexedItem(LUnit[] parameters)
	{
		LUnit key = getParameter(parameters, 0);
		LUnit item = items.get(key);

		return item != null ? item : LVoid.DESCRIPTOR.getInstance();
	}

	@Override
	public LUnit _setIndexedItem(LUnit[] parameters)
	{
		LUnit key = getParameter(parameters, 0);
		LUnit value = getParameter(parameters, 1);

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
		LMap map = unit.asType(DESCRIPTOR.getUnitType());

		return map != null ? LBoolean.valueOf(items.equals(map.items)) : LBoolean.FALSE.getInstance();
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
