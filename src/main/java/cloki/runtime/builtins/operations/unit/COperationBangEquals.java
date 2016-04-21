package cloki.runtime.builtins.operations.unit;

import cloki.runtime.builtins.operations.COperation;
import cloki.runtime.consts.CConstOperator;
import cloki.runtime.consts.CConstUnitMember;
import cloki.runtime.datatypes.CFalse;
import cloki.runtime.datatypes.CTrue;
import cloki.runtime.datatypes.CUnit;

public class COperationBangEquals extends COperation
{
	public static final COperationBangEquals instance = new COperationBangEquals();

	private COperationBangEquals()
	{
		super(CConstOperator.BANG_EQUALS);
	}

	@Override
	protected CUnit execute(CUnit leftOperand, CUnit rightOperand)
	{
		return !leftOperand.callMember(CConstUnitMember.EQUALS.name, new CUnit[]{rightOperand}, null).toBoolean() ? CTrue.instance : CFalse.instance;

	}
}
