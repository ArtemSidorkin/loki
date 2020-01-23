package loki.runtime.datatype.number.operation.unary;

import loki.runtime.builtin.operation.unary.LUnaryOperation;
import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnaryOperator;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.util.LErrors;
import loki.runtime.util.Nullable;

public abstract class LNumberUnaryOperation extends LUnaryOperation<LNumber>
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
