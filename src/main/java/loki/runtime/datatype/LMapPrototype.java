package loki.runtime.datatype;

import loki.runtime.constant.LTypes;
import loki.runtime.util.LErrors;
import loki.runtime.util.Nullable;

import java.util.*;

public class LMapPrototype extends LUnit
{
	public static final LMapPrototype instance = new LMapPrototype();

	@Nullable protected final Map<LUnit, LUnit> items = new HashMap<>();

	public LMapPrototype(LUnit[] items)
	{
		super(LTypes.MAP);

		if (items != null)
			for (int i = 0; i < items.length; i += 2) this.items.put(items[i], items[i + 1]);
	}

	private LMapPrototype()
	{
		this(null);
	}

	@Override
	public LUnit _getIndexedItem(@Nullable LUnit[] parameters)
	{
		LUnit key = checkCallParameter(parameters, 0);

		if (key == LUndefined.instance)
		{
			LErrors.printErrorIndexIsUndefined();
			return LUndefined.instance;
		}

		if (items == null) return LUndefined.instance;

		LUnit item = items.get(key);

		if (item != null) return item;
		else return LUndefined.instance;
	}

	@Override
	public LUnit _setIndexedItem(@Nullable LUnit[] parameters)
	{
		LUnit key = checkCallParameter(parameters, 0);

		if (key == LUndefined.instance)
		{
			LErrors.printErrorIndexIsUndefined();
			return LUndefined.instance;
		}

		LUnit value = checkCallParameter(parameters, 1);

		if (value == LUndefined.instance)
		{
			LErrors.printErrorIndexValueIsUndefined();
			return LUndefined.instance;
		}

		if (items != null)
		{
			items.put(key, value);
			return value;
		}

		return LUndefined.instance;
	}

	@Override
	public String _toString()
	{
		if (items == null || items.size() == 0) return "{}";

		StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");

		for (LUnit key : items.keySet()) stringJoiner.add(String.format("%s : %s", key, items.get(key)));

		return stringJoiner.toString();
	}
}
