package cloki.runtime.datatypes;

import java.util.StringJoiner;

public class CArray extends CArrayPrototype
{
	{
		addParent(CArrayPrototype.instance);
	}

	public CArray(CUnit[] items)
	{
		super(items);
	}

	@Override
	public String _toString()
	{
		if (items == null || items.size() == 0) return "[]";

		StringJoiner strngJnr = new StringJoiner(", ", "[", "]");
		for (CUnit itm : items) strngJnr.add(itm._toString());
		return strngJnr.toString();
	}
}
