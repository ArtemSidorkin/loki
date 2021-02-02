package loki.runtime.unit.data.array.member;

import loki.runtime.unit.data.array.LArray;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.member.LUnitMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static loki.runtime.error.LErrors.callbackResultHasWrongType;
import static loki.runtime.error.LErrors.hostHasWrongType;

public class LFilter extends LUnitMember<LFilter>
{
	public static final LInstanceDescriptor<LFilter> DESCRIPTOR =
		new LInstanceDescriptor<>("filter", LFilter.class, LFilter::new);

	private static final int PREDICATE_PARAMETER_INDEX = 0;

	private LFilter()
	{
		super(DESCRIPTOR);
	}

	@Override
	public LArray call(LUnit host, LUnit... parameters)
	{
		return new LArray(filterItems(host, hostToItems(host), getParameter(parameters, PREDICATE_PARAMETER_INDEX)));
	}

	private ArrayList<LUnit> filterItems(LUnit host, ArrayList<LUnit> items, LUnit predicate)
	{
		ArrayList<LUnit> filteredItems = new ArrayList<>();

		for (LUnit item : items)
			if (testItem(host, predicate, item)) filteredItems.add(item);

		return filteredItems;
	}

	private boolean testItem(LUnit host, LUnit predicate, LUnit item)
	{
		return predicate
			.call(host, item)
			.asType(LBoolean.DESCRIPTOR, callbackResultHasWrongType(host, DESCRIPTOR, PREDICATE_PARAMETER_INDEX))
			.getValue();
	}

	private ArrayList<LUnit> hostToItems(LUnit host)
	{
		return host.asType(LArray.DESCRIPTOR, hostHasWrongType(DESCRIPTOR)).getItems();
	}
}