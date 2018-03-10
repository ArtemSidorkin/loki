package loki.runtime.datatype.number.internal.operation;

import loki.runtime.constant.LUnaryOperator;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

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
