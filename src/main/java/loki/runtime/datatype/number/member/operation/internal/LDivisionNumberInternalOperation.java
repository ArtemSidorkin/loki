package loki.runtime.datatype.number.member.operation.internal;

import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LDivisionNumberInternalOperation extends LNumberInternalOperation
{
	public static final LDivisionNumberInternalOperation instance = new LDivisionNumberInternalOperation();

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		LNumber parameter = checkRightOperand(parameters);

		if (parameter != null) return new LNumber(value / parameter.getValue());

		return null;
	}
}
