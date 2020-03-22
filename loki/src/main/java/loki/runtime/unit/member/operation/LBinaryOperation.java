package loki.runtime.unit.member.operation;

import loki.runtime.LType;
import loki.runtime.error.LErrors;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.Nullable;

public abstract class LBinaryOperation<LEFT_OPERAND extends LUnit, RIGHT_OPERAND extends LUnit> extends LMember
{
	protected final @Nullable LType leftOperandType;
	protected final @Nullable LType rightOperandType;

	protected LBinaryOperation(LType type)
	{
		this(type, null, null);
	}

	protected LBinaryOperation(
		LType type, @Nullable LType leftOperandType, @Nullable LType rightOperandType
	)
	{
		super(type);

		this.leftOperandType = leftOperandType;
		this.rightOperandType = rightOperandType;
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		LEFT_OPERAND leftOperand = host.asType(leftOperandType);
		RIGHT_OPERAND rightOperand = checkCallParameter(parameters, 0).asType(rightOperandType);

		if (leftOperand == null || rightOperand == null)
		{
			LErrors.operandsShouldHaveTypes(leftOperand, leftOperandType, rightOperand, rightOperandType);

			return LVoid.DESCRIPTOR.getInstance();
		}

		return execute(leftOperand, rightOperand);
	}

	protected abstract LUnit execute(LEFT_OPERAND leftOperand, RIGHT_OPERAND rightOperand);
}
