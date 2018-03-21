package loki.runtime.datatype.number.member.operation.internal;

import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LInequalityNumberInternalOperation extends LNumberInternalOperation
{
	public static final LInequalityNumberInternalOperation instance = new LInequalityNumberInternalOperation();

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		LNumber parameter = checkRightOperand(parameters);

		if (parameter != null) return value != parameter.getValue() ? LTrue.instance : LFalse.instance;

		return LUndefined.instance;
	}
}
