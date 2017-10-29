package cloki.runtime.builtins.operations.number;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class COperationNumberBangEquals extends COperationHomogeneousNumber
{
	public static final COperationNumberBangEquals instance = new COperationNumberBangEquals();

	private COperationNumberBangEquals()
	{
		super(CConstOperator.BANG_EQUALS);
	}

	@Override
	protected LUnit operation(LNumber leftOperand, LNumber rightOperand)
	{
		return leftOperand.getValue() != rightOperand.getValue() ? LTrue.instance : LFalse.instance;
	}
}
