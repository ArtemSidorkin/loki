package loki.runtime.datatype.number.member.operation.internal;

import loki.runtime.constant.LTypes;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.number.member.internal.LNumberInternalMember;
import loki.runtime.util.Nullable;

public abstract class LNumberInternalOperation extends LNumberInternalMember
{
	protected LNumberInternalOperation(String designation)
	{
		super(designation);
	}

	@Nullable
	protected static LNumber checkRightOperand(LUnit[] parameters)
	{
		if (parameters.length > 0) return parameters[0].asType(LTypes.NUMBER);

		return null;
	}
}
