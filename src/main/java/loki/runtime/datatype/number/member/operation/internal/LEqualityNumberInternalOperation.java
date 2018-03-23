package loki.runtime.datatype.number.member.operation.internal;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.constant.LType;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.util.LErrors;

public class LEqualityNumberInternalOperation extends LNumberInternalOperation
{
	public static final LEqualityNumberInternalOperation instance = new LEqualityNumberInternalOperation();

	private LEqualityNumberInternalOperation()
	{
		super(LBinaryOperator.EQUALS_EQUALS.symbol);
	}

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		LNumber parameter = checkRightOperand(parameters);

		if (parameter != null) return value == parameter.value ? LTrue.instance : LFalse.instance;

		LErrors.printErrorRightOperandDoesNotBelongToTypeOrUndefined(LType.NUMBER.name);
		return LUndefined.instance;
	}
}
