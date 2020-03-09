package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.number.LNumber;
import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;

public class LSubtractionNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final String TYPE_NAME = LBinaryOperator.MINUS.symbol;
	public static final LType TYPE = new LType(TYPE_NAME, LSubtractionNumberBinaryOperation.class);

	public static final LSubtractionNumberBinaryOperation INSTANCE = new LSubtractionNumberBinaryOperation();

	private LSubtractionNumberBinaryOperation()
	{
		super(TYPE);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() - rightOperand.getValue());
	}
}
