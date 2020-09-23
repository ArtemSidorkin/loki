package loki.runtime.unit.member.operation;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LUnitDescriptor;

import static loki.runtime.error.LErrors.operandHasWrongType;
import static loki.runtime.unit.member.operation.LOperandPosition.SOLE;

public abstract class LUnaryOperation<OPERAND extends LUnit> extends LMember
{
	private LUnitDescriptor<?> unitDescriptor;
	private LUnitDescriptor<OPERAND> operandTypeDescriptor;

	protected LUnaryOperation(LUnitDescriptor<?> unitDescriptor, LUnitDescriptor<OPERAND> operandTypeDescriptor)
	{
		super(unitDescriptor.getType());

		this.unitDescriptor = unitDescriptor;
		this.operandTypeDescriptor = operandTypeDescriptor;
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return execute(host.asType(operandTypeDescriptor, operandHasWrongType(host, unitDescriptor, SOLE)));
	}

	protected abstract LUnit execute(OPERAND operand);
}
