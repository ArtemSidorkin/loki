package loki.runtime.datatype.number.operation.internal;

import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LUnaryMinusNumberInternalOperation extends LNumberInternalOperation
{
	public static final LUnaryMinusNumberInternalOperation instance = new LUnaryMinusNumberInternalOperation();

	@Override
	public LUnit apply(Double value, LUnit[] parameters)
	{
		return new LNumber(-value);
	}
}
