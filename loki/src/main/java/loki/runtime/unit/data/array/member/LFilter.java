package loki.runtime.unit.data.array.member;

import loki.runtime.unit.data.array.LArray;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static loki.runtime.error.LErrors.callbackOperationResultHasWrongType;
import static loki.runtime.error.LErrors.hostOperandHasWrongType;

public class LFilter extends LMember
{
	public static final LInstanceUnitDescriptor<LFilter> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("filter", LFilter.class, LFilter::new);

	public static final int INDEX_OF_PREDICATE_IN_PARAMETERS = 0;

	private LFilter()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	public LArray call(LUnit host, LUnit... parameters)
	{
		return
			new LArray(
				filterItems(host, hostToItems(host), checkCallParameter(parameters, INDEX_OF_PREDICATE_IN_PARAMETERS))
			);
	}

	private ArrayList<LUnit> filterItems(LUnit host, ArrayList<LUnit> items, LUnit predicate)
	{
		return
			items
				.stream()
				.filter(item -> testItem(host, predicate, item))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	private boolean testItem(LUnit host, LUnit predicate, LUnit item)
	{
		return
			predicate
				.call(host, item)
				.asType(
					LBoolean.DESCRIPTOR,
					callbackOperationResultHasWrongType(host, DESCRIPTOR, INDEX_OF_PREDICATE_IN_PARAMETERS)
				)
				.getValue();
	}

	private ArrayList<LUnit> hostToItems(LUnit host)
	{
		return host.asType(LArray.DESCRIPTOR, hostOperandHasWrongType(DESCRIPTOR)).getItems();
	}
}