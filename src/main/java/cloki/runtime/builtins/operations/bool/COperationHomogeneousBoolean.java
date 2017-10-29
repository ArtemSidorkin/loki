package cloki.runtime.builtins.operations.bool;

import cloki.runtime.builtins.operations.COperationHomogeneous;
import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.constant.LTypes;
import cloki.runtime.datatype.LBoolean;

public abstract class COperationHomogeneousBoolean extends COperationHomogeneous<LBoolean>
{
	protected COperationHomogeneousBoolean(LBinaryOperator operator)
	{
		super(operator, LTypes.BOOLEAN);
	}
}
