package loki.runtime.unit.number.member.operation.unary;

import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnaryOperator;
import loki.runtime.unit.LUndefined;
import loki.runtime.unit.member.operation.LUnaryOperation;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;
import loki.runtime.util.Nullable;

public abstract class LNumberUnaryOperation extends LUnaryOperation
{
	protected LNumberUnaryOperation(LUnaryOperator unaryOperator)
	{
		super(unaryOperator);
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		LNumber hostAsNumber = host.asType(LTypes.NUMBER);

		if (hostAsNumber != null) return execute(hostAsNumber);

		LErrors.unitDoesNotBelongToType(host, LTypes.NUMBER.getFullName());

		return LUndefined.instance;
	}

	protected abstract LUnit execute(LNumber operand);
}
