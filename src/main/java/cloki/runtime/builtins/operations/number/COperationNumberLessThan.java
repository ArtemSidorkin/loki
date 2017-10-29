package cloki.runtime.builtins.operations.number;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class COperationNumberLessThan extends COperationHomogeneousNumber
{
	public static final COperationNumberLessThan instance = new COperationNumberLessThan();

	private COperationNumberLessThan()
	{
		super(CConstOperator.LESS_THAN);
	}

	@Override
	protected LUnit operation(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.getValue() < rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
