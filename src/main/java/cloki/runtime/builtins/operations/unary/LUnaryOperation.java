package cloki.runtime.builtins.operations.unary;

import cloki.runtime.constant.LUnaryOperator;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;

public abstract class LUnaryOperation<OPERAND extends LUnit> extends LUnit
{
	protected final LUnaryOperator operator;

	protected LUnaryOperation(LUnaryOperator operator)
	{
		super(new LType(operator.symbol));
		this.operator = operator;
	}

	public void init(OPERAND operand)
	{
		operand.setMember(operator.symbol, this);
	}
}
