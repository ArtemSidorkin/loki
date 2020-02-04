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
	protected final LBinaryOperator operator;
	protected final @Nullable LType leftOperandType;
	protected final @Nullable LType rightOperandType;

	protected LBinaryOperation(LBinaryOperator operator)
	{
		this(operator, null, null);
	}

	protected LBinaryOperation(
		LBinaryOperator operator, @Nullable LType leftOperandType,  @Nullable LType rightOperandType
	)
	{
		super(new LType(operator.symbol));
		this.operator = operator;
		this.leftOperandType = leftOperandType;
		this.rightOperandType = rightOperandType;
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		return execute(host, checkCallParameter(parameters, 0));
	}

	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		LEFT_OPERAND leftOperandAsSpecifiedType =
			leftOperandType != null ? leftOperand.asType(leftOperandType) : (LEFT_OPERAND)leftOperand;

		if (leftOperandAsSpecifiedType == null)
		{
			operatorIsNotDefinedForUnits(leftOperand, rightOperand);

			return LUndefined.instance;
		}

		RIGHT_OPERAND rightOperandAsSpecifiedType =
			rightOperandType != null ? rightOperand.asType(rightOperandType) : (RIGHT_OPERAND)rightOperand;

		if (rightOperandAsSpecifiedType == null)
		{
			operatorIsNotDefinedForUnits(leftOperand, rightOperand);

			return LUndefined.instance;
		}

		return _execute(leftOperandAsSpecifiedType, rightOperandAsSpecifiedType);
	}

	protected abstract LUnit _execute(LEFT_OPERAND leftOperand, RIGHT_OPERAND rightOperand);

	private void operatorIsNotDefinedForUnits(LUnit leftOperand, LUnit rightOperand)
	{
		LErrors.operatorIsNotDefinedForUnits(operator, leftOperand, rightOperand);
	}
}
