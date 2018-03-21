package loki.runtime.datatype.number.member.operation.internal;

import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LMultiplicationNumberInternalOperation extends LNumberInternalOperation
{
	public static final LMultiplicationNumberInternalOperation instance = new LMultiplicationNumberInternalOperation();

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		LNumber parameter = checkRightOperand(parameters);

		if (parameter != null) return new LNumber(value * parameter.getValue());

		return null;
	}
}
