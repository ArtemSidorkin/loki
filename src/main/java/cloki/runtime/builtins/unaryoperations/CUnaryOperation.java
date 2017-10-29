package cloki.runtime.builtins.unaryoperations;

import cloki.runtime.consts.CConstUnaryOperator;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;

public abstract class CUnaryOperation<HOST extends LUnit> extends LUnit
{
	protected final CConstUnaryOperator operator;

	protected CUnaryOperation(CConstUnaryOperator operator)
	{
		super(new LType(operator.sign));
		this.operator = operator;
	}

	public void init(HOST unit)
	{
		unit.setMember(operator.sign, this);
	}
}
