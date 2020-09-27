package loki.runtime.unit.member.operation;

import loki.runtime.unit.member.LUnitMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;
import loki.runtime.unitdescriptor.LUnitDescriptor;

import static loki.runtime.error.LErrors.operandHasWrongType;
import static loki.runtime.unit.member.operation.LOperandPosition.ONLY;

public abstract class LUnaryOperation<OPERATION extends LUnit, OPERAND extends LUnit> extends LUnitMember<OPERATION>
{
	private LInstanceDescriptor<OPERATION> instanceDescriptor;
	private LUnitDescriptor<OPERAND> operandTypeDescriptor;

	protected LUnaryOperation(
		LInstanceDescriptor<OPERATION> instanceDescriptor, LUnitDescriptor<OPERAND> operandTypeDescriptor
	)
	{
		super(instanceDescriptor);

		this.instanceDescriptor = instanceDescriptor;
		this.operandTypeDescriptor = operandTypeDescriptor;
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return execute(host.asType(operandTypeDescriptor, operandHasWrongType(host, instanceDescriptor, ONLY)));
	}

	protected abstract LUnit execute(OPERAND operand);
}
