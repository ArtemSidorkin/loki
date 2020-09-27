package loki.runtime.unit.unit.member.operation.binary;

import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LEquality extends LUnitBinaryOperation<LEquality>
{
	public static final LInstanceDescriptor<LEquality> DESCRIPTOR =
		new LInstanceDescriptor<>("==", LEquality.class, LEquality::new);

	private LEquality()
	{
		super(DESCRIPTOR);
	}

	@Override
	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		return leftOperand._equals(rightOperand);
	}
}
