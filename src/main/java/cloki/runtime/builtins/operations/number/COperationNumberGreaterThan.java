package cloki.runtime.builtins.operations.number;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class COperationNumberGreaterThan extends COperationHomogeneousNumber
{
	public static final COperationNumberGreaterThan instance = new COperationNumberGreaterThan();

	private COperationNumberGreaterThan()
	{
		super(CConstOperator.GREATER_THAN);
	}

	@Override
	protected LUnit operation(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.getValue() > rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
