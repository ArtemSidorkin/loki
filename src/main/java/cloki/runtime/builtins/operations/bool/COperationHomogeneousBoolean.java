package cloki.runtime.builtins.operations.bool;

import cloki.runtime.builtins.operations.COperationHomogeneous;
import cloki.runtime.consts.CConstOperator;
import cloki.runtime.consts.CConstTypes;
import cloki.runtime.datatype.LBoolean;

public abstract class COperationHomogeneousBoolean extends COperationHomogeneous<LBoolean>
{
	protected COperationHomogeneousBoolean(CConstOperator operator)
	{
		super(operator, CConstTypes.BOOLEAN);
	}
}
