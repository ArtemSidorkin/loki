package loki.runtime.unit.member.operation;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.LUndefined;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;
import loki.runtime.util.Nullable;

public abstract class LBinaryOperation<LEFT_OPERAND extends LUnit, RIGHT_OPERAND extends LUnit>	extends LMember
{
	protected final LBinaryOperator binaryOperator;
	protected final @Nullable LType leftOperandType;
	protected final @Nullable LType rightOperandType;

	public LBinaryOperation(LBinaryOperator binaryOperator)
	{
		this(binaryOperator, null, null);
	}

	protected LBinaryOperation(
		LBinaryOperator binaryOperator, @Nullable LType leftOperandType, @Nullable LType rightOperandType
	)
	{
		super(new LType(binaryOperator.symbol));

		this.binaryOperator = binaryOperator;
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
			operatorIsNotDefinedForUnits(host, parameters[0]);

			return LUndefined.INSTANCE;
		}

		return execute(leftOperand, rightOperand);
	}

	protected abstract LUnit execute(LEFT_OPERAND leftOperand, RIGHT_OPERAND rightOperand);

	private void operatorIsNotDefinedForUnits(LUnit leftOperand, LUnit rightOperand)
	{
		LErrors.operatorIsNotDefinedForUnits(binaryOperator, leftOperand, rightOperand);
	}
}
