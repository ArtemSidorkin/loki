package loki.runtime.datatype.number.internal.operation;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

import java.util.concurrent.ConcurrentMap;

public class LLessThanNumberInternalOperation extends LNumberInternalOperation
{
	public static final LLessThanNumberInternalOperation instance = new LLessThanNumberInternalOperation();

	@Override
	public LUnit apply(ConcurrentMap<String, LUnit> members, Double value, LUnit[] parameters)
	{
		if (members == null || members.get(LBinaryOperator.LESS_THAN.symbol) == LUndefined.instance)
		{
			LNumber parameter = checkRightOperand(parameters);

			if (parameter != null) return value < parameter.getValue() ? LTrue.instance : LFalse.instance;
		}

		return null;
	}
}
