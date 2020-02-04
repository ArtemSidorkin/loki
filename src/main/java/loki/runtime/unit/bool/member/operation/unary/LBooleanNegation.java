package loki.runtime.unit.bool.member.operation.unary;

import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnaryOperator;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.member.operation.LUnaryOperation;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.Nullable;

public class LBooleanNegation extends LUnaryOperation
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

		if (hostAsBoolean != null) return LBoolean.valueOf(!hostAsBoolean.getValue());
		else return LBoolean.valueOf(!host.toBoolean());
	}
}
