package loki.runtime.datatype.number.member.operation.internal;

import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LNumericNegationNumberInternalOperation extends LNumberInternalOperation
{
	public static final LNumericNegationNumberInternalOperation instance = new LNumericNegationNumberInternalOperation();

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		return new LNumber(-value);
	}
}
