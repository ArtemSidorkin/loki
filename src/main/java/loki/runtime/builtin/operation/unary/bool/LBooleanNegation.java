package loki.runtime.builtin.operation.unary.bool;

import loki.runtime.builtin.operation.unary.LUnaryOperation;
import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnaryOperator;
import loki.runtime.datatype.*;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.util.Nullable;

public class LBooleanNegation extends LUnaryOperation<LBoolean>
{
	public static final LBooleanNegation instance = new LBooleanNegation();

	private LBooleanNegation()
	{
		super(LUnaryOperator.BANG);
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		LBoolean hostAsBoolean = host.asType(LTypes.BOOLEAN);

		if (hostAsBoolean != null) return LBoolean.valueOf(hostAsBoolean.getValue());
		else
		{
			boolean boolean_ =
				host != LVoid.instance &&
				host != LNone.instance &&
				host != LUndefined.instance &&
				(
					host.asType(LTypes.NUMBER) == null || ((LNumber) host.asType(LTypes.NUMBER)).value != 0
				);

			return LBoolean.valueOf(boolean_);
		}

	}
}
