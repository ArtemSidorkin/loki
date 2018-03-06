package cloki.runtime.datatype.number.internal.operation;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.datatype.number.LNumber;

import java.util.concurrent.ConcurrentMap;

public class LGreaterThanEqualsNumberInternalOperation extends LNumberInternalOperation
{
	public static final LGreaterThanEqualsNumberInternalOperation instance =
		new LGreaterThanEqualsNumberInternalOperation();

	@Override
	public LUnit apply(ConcurrentMap<String, LUnit> members, Double value, LUnit[] parameters)
	{
		if (members == null || members.get(LBinaryOperator.GREATER_THAN_EQUALS.symbol) == LUndefined.instance)
		{
			LNumber parameter = checkRightOperand(parameters);

			if (parameter != null) return value >= parameter.getValue() ? LTrue.instance : LFalse.instance;
		}

		return null;
	}
}
