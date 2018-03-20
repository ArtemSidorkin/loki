package loki.runtime.datatype.number.operation.internal;

import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LGreaterThanEqualsNumberInternalOperation extends LNumberInternalOperation
{
	public static final LGreaterThanEqualsNumberInternalOperation instance =
		new LGreaterThanEqualsNumberInternalOperation();

	@Override
	public LUnit apply(Double value, LUnit[] parameters)
	{
		LNumber parameter = checkRightOperand(parameters);

		if (parameter != null) return value >= parameter.getValue() ? LTrue.instance : LFalse.instance;

		return null;
	}
}
