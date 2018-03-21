package loki.runtime.datatype.number.member.operation.unary;

import loki.runtime.builtin.operation.unary.LUnaryOperation;
import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnaryOperator;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.number.LNumberPrototype;
import loki.runtime.util.LErrors;
import loki.runtime.util.Nullable;

public abstract class LNumberUnaryOperation extends LUnaryOperation<LNumberPrototype>
{
	public LNumberUnaryOperation(LUnaryOperator unaryOperator)
	{
		super(unaryOperator);
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		LNumber hostAsNumber = host.asType(LTypes.NUMBER);

		if (hostAsNumber != null) return execute(hostAsNumber);

		LErrors.printErrorUnitDoesNotBelongToType(host, LTypes.NUMBER.getNameWithId());
		return LUndefined.instance;
	}

	protected abstract LUnit execute(LNumber operand);
}
