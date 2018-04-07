package loki.runtime.datatype.number.member.operation.internal;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.constant.LType;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.util.LErrors;

public class LInequalityNumberInternalOperation extends LNumberInternalOperation
{
	public static final LInequalityNumberInternalOperation instance = new LInequalityNumberInternalOperation();

	private LInequalityNumberInternalOperation()
	{
		super(LBinaryOperator.BANG_EQUALS.symbol);
	}

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		LNumber parameter = checkRightOperand(parameters);

		if (parameter != null) return value != parameter.value ? LTrue.instance : LFalse.instance;

		LErrors.printErrorRightOperandDoesNotBelongToTypeOrUndefined(LType.NUMBER.name);
		return LUndefined.instance;
	}
}
