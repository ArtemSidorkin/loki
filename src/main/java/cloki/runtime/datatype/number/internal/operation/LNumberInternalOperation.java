package cloki.runtime.datatype.number.internal.operation;

import cloki.runtime.constant.LTypes;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.datatype.number.LNumber;
import cloki.runtime.utils.Nullable;

import java.util.concurrent.ConcurrentMap;

public abstract class LNumberInternalOperation
{
	public abstract LUnit apply(ConcurrentMap<String, LUnit> members, Double value, LUnit[] parameters);

	protected static LNumber checkRightOperand(@Nullable LUnit[] parameters)
	{
		if (parameters != null && 0 < parameters.length) return parameters[0].asType(LTypes.NUMBER);

		return null;
	}
}
