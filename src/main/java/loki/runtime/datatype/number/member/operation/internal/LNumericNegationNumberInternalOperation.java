package loki.runtime.datatype.number.member.operation.internal;

import loki.runtime.constant.LUnaryOperator;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LNumericNegationNumberInternalOperation extends LNumberInternalOperation
{
	public static final LNumericNegationNumberInternalOperation instance = new LNumericNegationNumberInternalOperation();

	private LNumericNegationNumberInternalOperation()
	{
		super(LUnaryOperator.MINUS.symbol);
	}

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		return new LNumber(-value);
	}
}
