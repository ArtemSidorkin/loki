package cloki.runtime.builtins.operations.binary.bool;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LBoolean;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class LBooleanAmpersandAmpersand extends LBooleanOperation
{
	public static final LBooleanAmpersandAmpersand instance = new LBooleanAmpersandAmpersand();

	private LBooleanAmpersandAmpersand()
	{
		super(LBinaryOperator.AMPERSAND_AMPERSAND);
	}

	@Override
	protected LUnit __execute(LBoolean leftOperand, LBoolean rightOperand)
	{
		return leftOperand.getValue() && rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
