package loki.runtime.unit.member.operation;

import loki.runtime.LType;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LUnitDescriptor;
import loki.runtime.util.Nullable;

import static loki.runtime.error.LErrors.operandHasWrongType;
import static loki.runtime.unit.member.operation.LOperandPosition.LEFT;
import static loki.runtime.unit.member.operation.LOperandPosition.RIGHT;

public abstract class LBinaryOperation<LEFT_OPERAND extends LUnit, RIGHT_OPERAND extends LUnit> extends LMember
{
	protected final @Nullable LUnitDescriptor<LEFT_OPERAND> leftOperandUnitDescriptor;
	protected final @Nullable LUnitDescriptor<RIGHT_OPERAND> rightOperandUnitDescriptor;

	protected LBinaryOperation(LType type)
	{
		this(type, null, null);
	}

	protected LBinaryOperation(
		LType type,
		@Nullable LUnitDescriptor<LEFT_OPERAND> leftOperandUnitDescriptor,
		@Nullable LUnitDescriptor<RIGHT_OPERAND> rightOperandUnitDescriptor
	)
	{
		super(type);
		this.leftOperandUnitDescriptor = leftOperandUnitDescriptor;
		this.rightOperandUnitDescriptor = rightOperandUnitDescriptor;
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		LEFT_OPERAND leftOperand =
			host.asType(leftOperandUnitDescriptor, operandHasWrongType(host, leftOperandUnitDescriptor, LEFT));

		RIGHT_OPERAND rightOperand =
			getParameter(parameters, 0)
				.asType(rightOperandUnitDescriptor, operandHasWrongType(host, rightOperandUnitDescriptor, RIGHT));

		return execute(leftOperand, rightOperand);
	}

	protected abstract LUnit execute(LEFT_OPERAND leftOperand, RIGHT_OPERAND rightOperand);
}
