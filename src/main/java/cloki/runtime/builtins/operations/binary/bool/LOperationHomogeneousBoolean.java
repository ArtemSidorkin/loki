package cloki.runtime.builtins.operations.binary.bool;

import cloki.runtime.builtins.operations.binary.LBinaryOperationHomogeneous;
import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.constant.LTypes;
import cloki.runtime.datatype.LBoolean;
import cloki.runtime.datatype.LBooleanPrototype;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;

public abstract class LOperationHomogeneousBoolean extends LBinaryOperationHomogeneous<LBooleanPrototype>
{
	protected LOperationHomogeneousBoolean(LBinaryOperator operator)
	{
		super(operator, LTypes.BOOLEAN);
	}

	@Override
	protected LUnit operation(LUnit leftOperand, LUnit rightOperand)
	{
		LBoolean leftOperandAsBoolean = leftOperand.asType(LTypes.BOOLEAN);
		LBoolean rightOperandAsBoolean = rightOperand.asType(LTypes.BOOLEAN);

		if (leftOperandAsBoolean == null || rightOperandAsBoolean == null)
		{
			printErrorUndefinedOperation(leftOperand, rightOperand);
			return LUndefined.instance;
		}

		return _operation(leftOperandAsBoolean, rightOperandAsBoolean);
	}

	abstract LUnit _operation(LBoolean leftOperand, LBoolean rightOperand);
}
