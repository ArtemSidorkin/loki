package cloki.runtime.builtins.operations.unit;

import cloki.runtime.builtins.operations.COperation;
import cloki.runtime.consts.CConstOperator;
import cloki.runtime.consts.LConstUnitMember;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class COperationBangEquals extends COperation
{
	public static final COperationBangEquals instance = new COperationBangEquals();

	private COperationBangEquals()
	{
		super(CConstOperator.BANG_EQUALS);
	}

	@Override
	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		return !leftOperand.callMember(LConstUnitMember.EQUALS.name, new LUnit[]{rightOperand}, null).toBoolean() ? LTrue.instance : LFalse.instance;

	}
}
