package loki.runtime.datatype.number.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;

public class LNumberBangEquals extends LNumberOperation
{
	public static final LNumberBangEquals instance = new LNumberBangEquals();

	private LNumberBangEquals()
	{
		super(LBinaryOperator.BANG_EQUALS);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.getValue() != rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
