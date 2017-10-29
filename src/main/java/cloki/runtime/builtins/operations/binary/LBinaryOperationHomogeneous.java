package cloki.runtime.builtins.operations.binary;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;

public abstract class LBinaryOperationHomogeneous<OPERAND_TYPE extends LUnit> extends LBinaryOperation<OPERAND_TYPE>
{
	private LType operandType;

	protected LBinaryOperationHomogeneous(LBinaryOperator operator, LType operandType)
	{
		super(operator);
		this.operandType = operandType;
	}

	@Override
	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		LUnit leftOperandAsSpecifiedType = leftOperand.asType(operandType);
		LUnit rightOperandAsSpecifiedType = rightOperand.asType(operandType);

		if (leftOperandAsSpecifiedType != null && rightOperandAsSpecifiedType != null)
			return operation(leftOperandAsSpecifiedType, rightOperandAsSpecifiedType);

		printErrorUndefinedOperation(leftOperand, rightOperand);
		return LUndefined.instance;
	}

	protected LUnit operation(LUnit leftOperand, LUnit rightOperand)
	{
		printErrorUndefinedOperation(leftOperand, rightOperand);
		return LUndefined.instance;
	}
}
