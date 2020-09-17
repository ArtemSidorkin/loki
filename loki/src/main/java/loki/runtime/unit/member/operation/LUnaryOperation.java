package loki.runtime.unit.member.operation;

import loki.runtime.LType;
import loki.runtime.error.LErrors;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;

public abstract class LUnaryOperation<OPERAND extends LUnit> extends LMember
{
	private LType operandType;

	protected LUnaryOperation(LType type, LType operandType)
	{
		super(type);
		this.operandType = operandType;
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		OPERAND operand = host.asType(operandType);

		if (operand != null) return execute(operand);

		LErrors.operandShouldHaveType(host, operandType);

		return LVoid.DESCRIPTOR.getInstance();
	}

	protected abstract LUnit execute(OPERAND operand);
}
