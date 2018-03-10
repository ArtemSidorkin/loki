package loki.runtime.builtin.operation.binary.number;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LUnit;

public class LNumberLessThan extends LNumberOperation
{
	public static final LNumberLessThan instance = new LNumberLessThan();

	private LNumberLessThan()
	{
		super(LBinaryOperator.LESS_THAN);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.getValue() < rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
