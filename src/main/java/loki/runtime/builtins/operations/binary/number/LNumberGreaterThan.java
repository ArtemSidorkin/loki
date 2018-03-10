package loki.runtime.builtins.operations.binary.number;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LUnit;

public class LNumberGreaterThan extends LNumberOperation
{
	public static final LNumberGreaterThan instance = new LNumberGreaterThan();

	private LNumberGreaterThan()
	{
		super(LBinaryOperator.GREATER_THAN);
	}

	@Override
	protected LUnit __execute(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.getValue() > rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
