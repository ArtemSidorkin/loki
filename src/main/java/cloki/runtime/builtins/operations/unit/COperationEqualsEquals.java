package cloki.runtime.builtins.operations.unit;

import cloki.runtime.builtins.operations.COperation;
import cloki.runtime.consts.CConstOperator;
import cloki.runtime.consts.LConstUnitMember;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class COperationEqualsEquals extends COperation
{
	public static final COperationEqualsEquals instance = new COperationEqualsEquals();

	private COperationEqualsEquals()
	{
		super(CConstOperator.EQUALS_EQUALS);
	}

	@Override
	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		return leftOperand.callMember(LConstUnitMember.EQUALS.name, new LUnit[]{rightOperand}, null).toBoolean() ? LTrue.instance : LFalse.instance;
	}
}
