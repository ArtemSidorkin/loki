package cloki.runtime.builtins.operations.binary.number;

import cloki.runtime.builtins.operations.binary.LBinaryOperationHomogeneous;
import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.constant.LTypes;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LNumberPrototype;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;

public abstract class LOperationHomogeneousNumber extends LBinaryOperationHomogeneous<LNumberPrototype>
{
	protected LOperationHomogeneousNumber(LBinaryOperator operator)
	{
		super(operator, LTypes.NUMBER);
	}

	@Override
	protected LUnit operation(LUnit leftOperand, LUnit rightOperand)
	{
		LNumber leftOperandAsNumber = leftOperand.asType(LTypes.NUMBER);
		LNumber rightOperandAsNumber = rightOperand.asType(LTypes.NUMBER);

		if (leftOperandAsNumber == null || rightOperandAsNumber == null)
		{
			printErrorUndefinedOperation(leftOperand, rightOperand);
			return LUndefined.instance;
		}

		return _operation(leftOperandAsNumber, rightOperandAsNumber);
	}

	abstract LUnit _operation(LNumber leftOperand, LNumber rightOperand);
}
