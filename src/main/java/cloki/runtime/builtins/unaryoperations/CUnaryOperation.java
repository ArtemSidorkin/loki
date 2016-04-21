package cloki.runtime.builtins.unaryoperations;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.consts.CConstUnaryOperator;
import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.CErrors;
import cloki.runtime.utils.Nullable;

public abstract class CUnaryOperation<HOST extends CUnit> extends CUnit
{
	protected final CConstUnaryOperator operator;

	protected CUnaryOperation(CConstUnaryOperator operator)
	{
		super(new CType(operator.sign));
		this.operator = operator;
	}

	public void init(HOST unit)
	{
		unit.setMember(operator.sign, this);
	}
}
