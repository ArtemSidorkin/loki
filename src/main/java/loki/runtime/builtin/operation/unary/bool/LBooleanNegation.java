package loki.runtime.builtin.operation.unary.bool;

import loki.runtime.builtin.operation.unary.LUnaryOperation;
import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnaryOperator;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.*;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.util.Nullable;

public class LBooleanNegation extends LUnaryOperation<LBooleanPrototype>
{
	public static final LBooleanNegation instance = new LBooleanNegation();

	private LBooleanNegation()
	{
		super(LUnaryOperator.BANG);
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		LBoolean hostAsBoolean = host.asType(LTypes.BOOLEAN);

		if (hostAsBoolean != null) return hostAsBoolean.getValue() ? LFalse.instance : LTrue.instance;
		else
			return (
				host != LVoid.instance &&
				host != LNone.instance &&
				host != LUndefined.instance &&
				(
					host.asType(LTypes.NUMBER) == null || ((LNumber) host.asType(LTypes.NUMBER)).getValue() != 0
				)
			)
				? LFalse.instance
				: LTrue.instance;
	}
}
