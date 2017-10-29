package cloki.runtime.builtins.operations.unary.bool;

import cloki.runtime.builtins.operations.unary.LUnaryOperation;
import cloki.runtime.constant.LTypes;
import cloki.runtime.constant.LUnaryOperator;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.*;
import cloki.runtime.utils.Nullable;

public class LLogicalNegation extends LUnaryOperation<LBooleanPrototype>
{
	public static final LLogicalNegation instance = new LLogicalNegation();

	private LLogicalNegation()
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
