package loki.runtime.builtin.operation.binary.unit;

import loki.runtime.builtin.operation.binary.LBinaryOperation;
import loki.runtime.constant.LBinaryOperator;
import loki.runtime.constant.LUnitMember;
import loki.runtime.datatype.LFalse;
import loki.runtime.datatype.LTrue;
import loki.runtime.datatype.LUnit;

public class LUnitEqualsEquals extends LBinaryOperation<LUnit, LUnit, LUnit>
{
	public static final LUnitEqualsEquals instance = new LUnitEqualsEquals();

	private LUnitEqualsEquals()
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
