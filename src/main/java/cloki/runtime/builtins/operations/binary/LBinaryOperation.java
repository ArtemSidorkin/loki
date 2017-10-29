package cloki.runtime.builtins.operations.binary;

import cloki.runtime.builtins.operations.LOperation;
import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;

public abstract class LBinaryOperation<
	HOST_OPERAND extends LUnit, LEFT_OPERAND extends LUnit, RIGHT_OPERAND extends LUnit
>
	extends LOperation<HOST_OPERAND>
{
	protected final LBinaryOperator operator;
	@Nullable protected final LType leftOperandType;
	@Nullable protected final LType rightOperandType;

	protected LBinaryOperation(LBinaryOperator operator)
	{
		this(operator, null);
	}

	protected LBinaryOperation(LBinaryOperator operator, @Nullable LType leftOperandType)
	{
		this(operator, leftOperandType, null);
	}

	protected LBinaryOperation(
		LBinaryOperator operator, @Nullable LType leftOperandType, @Nullable LType rightOperandType
	)
	{
		super(new LType(operator.symbol));
		this.operator = operator;
		this.leftOperandType = leftOperandType;
		this.rightOperandType = rightOperandType;
	}

	@Override
	protected String getSymbol() {
		return operator.symbol;
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return execute(host, checkCallParameter(parameters, 0));
	}

	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		if (leftOperandType == null)
			throw new IllegalArgumentException("Left operand type should be specified or method should be overridden");

		LEFT_OPERAND leftOperandAsSpecifiedType  = leftOperand.asType(leftOperandType);

		if (leftOperandAsSpecifiedType == null)
		{
			printErrorUndefinedOperation(leftOperand, rightOperand);
			return LUndefined.instance;
		}

		return _execute(leftOperandAsSpecifiedType, rightOperand);
	}

	protected LUnit _execute(LEFT_OPERAND leftOperand, LUnit rightOperand)
	{
		if (leftOperandType == null)
			throw new IllegalArgumentException("Right operand type should be specified or method should be overridden");

		RIGHT_OPERAND rightOperandAsSpecifiedType = rightOperand.asType(rightOperandType);

		if (rightOperandAsSpecifiedType == null)
		{
			printErrorUndefinedOperation(leftOperand, rightOperand);
			return LUndefined.instance;
		}

		return __execute(leftOperand, rightOperandAsSpecifiedType);
	}

	protected LUnit __execute(LEFT_OPERAND leftOperand, RIGHT_OPERAND rightOperand) {return LUndefined.instance;}

	protected void printErrorUndefinedOperation(LUnit leftOperand, LUnit rightOperand)
	{
		LErrors.printErrorOperatorIsNotDefinedForUnits(operator, leftOperand, rightOperand);
	}
}
