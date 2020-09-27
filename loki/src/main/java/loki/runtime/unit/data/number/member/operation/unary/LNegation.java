package loki.runtime.unit.data.number.member.operation.unary;

import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LNegation extends LNumberUnaryOperation<LNegation>
{
	public static final LInstanceDescriptor<LNegation> DESCRIPTOR =
		new LInstanceDescriptor<>("-_", LNegation.class, LNegation::new);

	private LNegation()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LNumber operand)
	{
		return new LNumber(-operand.getValue());
	}
}
