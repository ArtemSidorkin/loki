package loki.runtime.unit.data.array.member;

import loki.runtime.error.LErrors;
import loki.runtime.unit.data.array.LArray;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

import java.util.ArrayList;

public class LFilter extends LMember
{
	public static final LInstanceUnitDescriptor<LFilter> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("filter", LFilter.class, LFilter::new);

	private LFilter()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	public LArray call(LUnit host, LUnit[] parameters)
	{
		LArray hostAsArray = host.asType(LArray.DESCRIPTOR.getType());

		if (hostAsArray == null) LErrors.operandShouldHaveType(host, LArray.DESCRIPTOR.getType());

		LUnit filterFunction = checkCallParameter(parameters, 0);

		ArrayList<LUnit> filteredItems = new ArrayList<>();

		LUnit[] itemAsFilterUnitCallParameter = new LUnit[1];

		for (LUnit item : hostAsArray.getItems())
		{
			itemAsFilterUnitCallParameter[0] = item;

			LUnit filterResult = filterFunction.call(host, itemAsFilterUnitCallParameter);

			LBoolean filterResultAsBoolean = filterResult.asType(LBoolean.DESCRIPTOR.getType());

			if (filterResultAsBoolean == null)
				LErrors
					.resultOfOperationOfUnitShouldHaveType(
						LFilter.DESCRIPTOR.getType(), filterResult, LBoolean.DESCRIPTOR.getType()
					);

			if (filterResultAsBoolean.getValue()) filteredItems.add(item);
		}

		return new LArray(filteredItems);
	}
}
