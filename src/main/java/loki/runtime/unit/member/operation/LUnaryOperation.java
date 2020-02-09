package loki.runtime.unit.member.operation;

import loki.runtime.constant.LUnaryOperator;
import loki.runtime.unit.LUndefined;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;

public abstract class LUnaryOperation<OPERAND extends LUnit> extends LMember
{
	private LType operandType;

	protected LUnaryOperation(LUnaryOperator unaryOperator, LType operandType)
	{
		super(new LType(unaryOperator.symbol));
		this.operandType = operandType;
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		OPERAND operand = host.asType(operandType);

		if (operand != null) return execute(operand);

		LErrors.unitDoesNotBelongToType(host, operandType);

		return LUndefined.instance;
	}

	protected abstract LUnit execute(OPERAND operand);
}
