package cloki.runtime.builtins.operations.number;

import cloki.runtime.builtins.operations.COperationHomogeneous;
import cloki.runtime.consts.CConstOperator;
import cloki.runtime.consts.CConstTypes;
import cloki.runtime.datatype.LNumber;

public abstract class COperationHomogeneousNumber extends COperationHomogeneous<LNumber>
{
	protected COperationHomogeneousNumber(CConstOperator operator)
	{
		super(operator, CConstTypes.NUMBER);
	}
}
