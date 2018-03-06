package cloki.runtime.datatype.number.internal.operation;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.datatype.number.LNumber;

import java.util.concurrent.ConcurrentMap;

public class LStarNumberInternalOperation extends LNumberInternalOperation
{
	public static final LStarNumberInternalOperation instance = new LStarNumberInternalOperation();

	@Override
	public LUnit apply(ConcurrentMap<String, LUnit> members, Double value, LUnit[] parameters)
	{
		if (members == null || members.get(LBinaryOperator.STAR.symbol) == LUndefined.instance)
		{
			LNumber parameter = checkRightOperand(parameters);

			if (parameter != null) return new LNumber(value * parameter.getValue());
		}

		return null;
	}
}
