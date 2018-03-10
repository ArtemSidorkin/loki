package loki.runtime.datatype.number.internal.operation;

import loki.runtime.constant.LTypes;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.util.Nullable;

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
