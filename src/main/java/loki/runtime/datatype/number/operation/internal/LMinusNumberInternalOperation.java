package loki.runtime.datatype.number.operation.internal;

import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LMinusNumberInternalOperation extends LNumberInternalOperation
{
	public static final LMinusNumberInternalOperation instance = new LMinusNumberInternalOperation();

	@Override
	public LUnit apply(Double value, LUnit[] parameters)
	{
		LNumber parameter = checkRightOperand(parameters);

		if (parameter != null) return new LNumber(value - parameter.getValue());

		return null;
	}
}
