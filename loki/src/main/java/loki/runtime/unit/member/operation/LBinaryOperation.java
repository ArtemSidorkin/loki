package loki.runtime.unit.member.operation;

import loki.runtime.marker.Nullable;
import loki.runtime.unit.member.LUnitMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;
import loki.runtime.unitdescriptor.LUnitDescriptor;

import static loki.runtime.error.LErrors.operandHasWrongType;
import static loki.runtime.unit.member.operation.LOperandPosition.LEFT;
import static loki.runtime.unit.member.operation.LOperandPosition.RIGHT;

public abstract class LBinaryOperation<OPERATION extends LUnit, LEFT_OPERAND extends LUnit, RIGHT_OPERAND extends LUnit>
	extends LUnitMember<OPERATION>
{
	private static final int RIGHT_OPERAND_PARAMETER_INDEX = 0;

	protected final @Nullable LUnitDescriptor<LEFT_OPERAND> leftOperandUnitDescriptor;
	protected final @Nullable LUnitDescriptor<RIGHT_OPERAND> rightOperandUnitDescriptor;

	protected LBinaryOperation(LInstanceDescriptor<OPERATION> instanceDescriptor)
	{
		this(instanceDescriptor, null, null);
	}

	protected LBinaryOperation(
		LInstanceDescriptor<OPERATION> instanceDescriptor,
		@Nullable LUnitDescriptor<LEFT_OPERAND> leftOperandDescriptor,
		@Nullable LUnitDescriptor<RIGHT_OPERAND> rightOperandDescriptor
	)
	{
		super(instanceDescriptor);

		this.leftOperandUnitDescriptor = leftOperandDescriptor;
		this.rightOperandUnitDescriptor = rightOperandDescriptor;
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		LEFT_OPERAND leftOperand =
			host.asType(leftOperandUnitDescriptor, operandHasWrongType(host, leftOperandUnitDescriptor, LEFT));

		RIGHT_OPERAND rightOperand =
			getParameter(parameters, RIGHT_OPERAND_PARAMETER_INDEX)
				.asType(rightOperandUnitDescriptor, operandHasWrongType(host, rightOperandUnitDescriptor, RIGHT));

		return execute(leftOperand, rightOperand);
	}

	protected abstract LUnit execute(LEFT_OPERAND leftOperand, RIGHT_OPERAND rightOperand);
}
