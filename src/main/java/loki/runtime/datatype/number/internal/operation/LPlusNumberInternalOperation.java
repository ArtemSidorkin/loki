package loki.runtime.datatype.number.internal.operation;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

import java.util.concurrent.ConcurrentMap;

public class LPlusNumberInternalOperation extends LNumberInternalOperation
{
	public static final LPlusNumberInternalOperation instance = new LPlusNumberInternalOperation();

	@Override
	public LUnit apply(ConcurrentMap<String, LUnit> members, Double value, LUnit[] parameters)
	{
		if (members == null || members.get(LBinaryOperator.PLUS.symbol) == LUndefined.instance)
		{
			LNumber parameter = checkRightOperand(parameters);

			if (parameter != null) return new LNumber(value + parameter.getValue());
		}

		return null;
	}
}
