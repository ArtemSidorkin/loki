package loki.runtime.datatype.number.member.operation.internal;

import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LSubtractionNumberInternalOperation extends LNumberInternalOperation
{
	public static final LSubtractionNumberInternalOperation instance = new LSubtractionNumberInternalOperation();

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		LNumber parameter = checkRightOperand(parameters);

		if (parameter != null) return new LNumber(value - parameter.getValue());

		return null;
	}
}
