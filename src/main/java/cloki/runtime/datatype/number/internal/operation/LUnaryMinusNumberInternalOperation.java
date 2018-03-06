package cloki.runtime.datatype.number.internal.operation;

import cloki.runtime.constant.LUnaryOperator;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.datatype.number.LNumber;

import java.util.concurrent.ConcurrentMap;

public class LUnaryMinusNumberInternalOperation extends LNumberInternalOperation
{
	public static final LUnaryMinusNumberInternalOperation instance = new LUnaryMinusNumberInternalOperation();

	@Override
	public LUnit apply(ConcurrentMap<String, LUnit> members, Double value, LUnit[] parameters)
	{
		if (members == null || members.get(LUnaryOperator.MINUS.symbol) == LUndefined.instance)
			return new LNumber(-value);

		return null;
	}
}
