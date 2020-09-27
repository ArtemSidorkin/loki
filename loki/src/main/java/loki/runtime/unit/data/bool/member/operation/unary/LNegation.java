package loki.runtime.unit.data.bool.member.operation.unary;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LNegation extends LBooleanUnaryOperation<LNegation>
{
	public static final LInstanceDescriptor<LNegation> DESCRIPTOR =
		new LInstanceDescriptor<>("!_", LNegation.class, LNegation::new);

	private LNegation()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LBoolean operand)
	{
		return LBoolean.valueOf(!operand.getValue());
	}
}
