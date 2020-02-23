package loki.runtime.unit.number.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LAdditionNumberBinaryOperation extends LNumberBinaryOperation
{
	public static final String TYPE_NAME = LBinaryOperator.PLUS.symbol;
	public static final LType TYPE = new LType(TYPE_NAME, LAdditionNumberBinaryOperation.class);

	public static final LAdditionNumberBinaryOperation INSTANCE = new LAdditionNumberBinaryOperation();

	private LAdditionNumberBinaryOperation()
	{
		super(TYPE);
	}

	@Override
	protected LUnit execute(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() + rightOperand.getValue());
	}
}
