package cloki.runtime.builtins.operations.number;

import cloki.runtime.builtins.operations.COperationHomogeneous;
import cloki.runtime.consts.CConstOperator;
import cloki.runtime.consts.CConstTypes;
import cloki.runtime.datatypes.CNumber;

public abstract class COperationHomogeneousNumber extends COperationHomogeneous<CNumber>
{
	protected COperationHomogeneousNumber(CConstOperator operator)
	{
		super(operator, CConstTypes.NUMBER);
	}
}
