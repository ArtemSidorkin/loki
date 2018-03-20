package loki.runtime.datatype.number.operation.internal;

import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LBangEqualsNumberInternalOperation extends LNumberInternalOperation
{
	public static final LBangEqualsNumberInternalOperation instance = new LBangEqualsNumberInternalOperation();

	@Override
	public LUnit apply(Double value, LUnit[] parameters)
	{
		LNumber parameter = checkRightOperand(parameters);

		if (parameter != null) return value != parameter.getValue() ? LTrue.instance : LFalse.instance;

		return LUndefined.instance;
	}
}
