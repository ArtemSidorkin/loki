package loki.runtime.unit.member.operation;

import loki.runtime.LType;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LTypeUnitDescriptor;
import loki.runtime.util.Nullable;

import static loki.runtime.error.LErrors.operandHasWrongType;
import static loki.runtime.unit.member.operation.LOperandPosition.LEFT;
import static loki.runtime.unit.member.operation.LOperandPosition.RIGHT;

public abstract class LBinaryOperation<LEFT_OPERAND extends LUnit, RIGHT_OPERAND extends LUnit> extends LMember
{
	protected final @Nullable LTypeUnitDescriptor<LEFT_OPERAND> leftOperandTypeDescriptor;
	protected final @Nullable LTypeUnitDescriptor<RIGHT_OPERAND> rightOperandTypeDescriptor;

	protected LBinaryOperation(LType type)
	{
		this(type, null, null);
	}

	protected LBinaryOperation(
		LType type,
		@Nullable LTypeUnitDescriptor<LEFT_OPERAND> leftOperandTypeDescriptor,
		@Nullable LTypeUnitDescriptor<RIGHT_OPERAND> rightOperandTypeDescriptor
	)
	{
		super(type);
		this.leftOperandTypeDescriptor = leftOperandTypeDescriptor;
		this.rightOperandTypeDescriptor = rightOperandTypeDescriptor;
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		LEFT_OPERAND leftOperand =
			host.asType(leftOperandTypeDescriptor, operandHasWrongType(host, leftOperandTypeDescriptor, LEFT));

		RIGHT_OPERAND rightOperand =
			getParameter(parameters, 0)
				.asType(rightOperandTypeDescriptor, operandHasWrongType(host, rightOperandTypeDescriptor, RIGHT));

		return execute(leftOperand, rightOperand);
	}

	protected abstract LUnit execute(LEFT_OPERAND leftOperand, RIGHT_OPERAND rightOperand);
}
