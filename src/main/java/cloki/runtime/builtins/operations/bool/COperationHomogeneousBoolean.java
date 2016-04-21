package cloki.runtime.builtins.operations.bool;

import cloki.runtime.builtins.operations.COperationHomogeneous;
import cloki.runtime.consts.CConstOperator;
import cloki.runtime.consts.CConstTypes;
import cloki.runtime.datatypes.CBoolean;
import cloki.runtime.datatypes.CNumber;

public abstract class COperationHomogeneousBoolean extends COperationHomogeneous<CBoolean>
{
	protected COperationHomogeneousBoolean(CConstOperator operator)
	{
		super(operator, CConstTypes.BOOLEAN);
	}
}
