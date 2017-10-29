package cloki.runtime.builtins.operations.bool;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LBoolean;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class COperationBooleanAmpersandAmpersand extends COperationHomogeneousBoolean
{
	public static final COperationBooleanAmpersandAmpersand instance = new COperationBooleanAmpersandAmpersand();

	private COperationBooleanAmpersandAmpersand()
	{
		super(LBinaryOperator.AMPERSAND_AMPERSAND);
	}

	@Override
	protected LUnit operation(LBoolean leftOperand, LBoolean rightOperand)
	{
		return leftOperand.getValue() && rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
