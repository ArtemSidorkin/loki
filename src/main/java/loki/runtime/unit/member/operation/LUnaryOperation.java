package loki.runtime.unit.member.operation;

import loki.runtime.unit.LVoid;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;

public abstract class LUnaryOperation<OPERAND extends LUnit> extends LMember
{
	private LType operandType;

	protected LUnaryOperation(LType type, LType operandType)
	{
		super(type);
		this.operandType = operandType;
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		OPERAND operand = host.asType(operandType);

		if (operand != null) return execute(operand);

		LErrors.operandShouldHaveType(host, operandType);

		return LVoid.INSTANCE;
	}

	protected abstract LUnit execute(OPERAND operand);
}
