package loki.runtime.unit.member.operation;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LTypeUnitDescriptor;

import static loki.runtime.error.LErrors.operandHasWrongType;
import static loki.runtime.unit.member.operation.LOperandPosition.SOLE;

public abstract class LUnaryOperation<OPERAND extends LUnit> extends LMember
{
	private LTypeUnitDescriptor<?> typeDescriptor;
	private LTypeUnitDescriptor<OPERAND> operandTypeDescriptor;

	protected LUnaryOperation(LTypeUnitDescriptor<?> typeDescriptor, LTypeUnitDescriptor<OPERAND> operandTypeDescriptor)
	{
		super(typeDescriptor.getType());

		this.typeDescriptor = typeDescriptor;
		this.operandTypeDescriptor = operandTypeDescriptor;
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return execute(host.asType(operandTypeDescriptor, operandHasWrongType(host, typeDescriptor, SOLE)));
	}

	protected abstract LUnit execute(OPERAND operand);
}
