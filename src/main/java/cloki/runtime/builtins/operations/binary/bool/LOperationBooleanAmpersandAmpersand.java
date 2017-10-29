package cloki.runtime.builtins.operations.binary.bool;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LBoolean;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class LOperationBooleanAmpersandAmpersand extends LOperationHomogeneousBoolean
{
	public static final LOperationBooleanAmpersandAmpersand instance = new LOperationBooleanAmpersandAmpersand();

	private LOperationBooleanAmpersandAmpersand()
	{
		super(LBinaryOperator.AMPERSAND_AMPERSAND);
	}

	@Override
	LUnit _operation(LBoolean leftOperand, LBoolean rightOperand)
	{
		return leftOperand.getValue() && rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
