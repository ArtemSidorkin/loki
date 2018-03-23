package loki.runtime.datatype.number.member.operation.internal;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.constant.LType;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.util.LErrors;

public class LDivisionNumberInternalOperation extends LNumberInternalOperation
{
	public static final LDivisionNumberInternalOperation instance = new LDivisionNumberInternalOperation();

	private LDivisionNumberInternalOperation()
	{
		super(LBinaryOperator.SLASH.symbol);
	}

	@Override
	public LUnit apply(double value, LUnit[] parameters)
	{
		LNumber parameter = checkRightOperand(parameters);

		if (parameter != null) return new LNumber(value / parameter.value);

		LErrors.printErrorRightOperandDoesNotBelongToTypeOrUndefined(LType.NUMBER.name);
		return LUndefined.instance;
	}
}