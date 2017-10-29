package cloki.runtime.builtins.operations.number;

import cloki.runtime.builtins.operations.COperationHomogeneous;
import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.constant.LTypes;
import cloki.runtime.datatype.LNumber;

public abstract class COperationHomogeneousNumber extends COperationHomogeneous<LNumber>
{
	protected COperationHomogeneousNumber(LBinaryOperator operator)
	{
		super(operator, LTypes.NUMBER);
	}
}
