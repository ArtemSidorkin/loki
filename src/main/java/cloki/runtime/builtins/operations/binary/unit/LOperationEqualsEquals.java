package cloki.runtime.builtins.operations.binary.unit;

import cloki.runtime.builtins.operations.binary.LBinaryOperation;
import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.constant.LUnitMember;
import cloki.runtime.datatype.LFalse;
import cloki.runtime.datatype.LTrue;
import cloki.runtime.datatype.LUnit;

public class LOperationEqualsEquals extends LBinaryOperation<LUnit>
{
	public static final LOperationEqualsEquals instance = new LOperationEqualsEquals();

	private LOperationEqualsEquals()
	{
		super(LBinaryOperator.EQUALS_EQUALS);
	}

	@Override
	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		return leftOperand
			.callMember(LUnitMember.EQUALS.name, new LUnit[] {rightOperand}, null).toBoolean()
				? LTrue.instance
				: LFalse.instance;
	}
}
