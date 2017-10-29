package cloki.runtime.builtins.operations.unary;

import cloki.runtime.builtins.operations.LOperation;
import cloki.runtime.constant.LUnaryOperator;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;

public abstract class LUnaryOperation<HOST_OPERAND extends LUnit> extends LOperation<HOST_OPERAND>
{
	protected final LUnaryOperator operator;

	protected LUnaryOperation(LUnaryOperator operator)
	{
		super(new LType(operator.symbol));
		this.operator = operator;
	}

	public void init(HOST_OPERAND hostOperand)
	{
		hostOperand.setMember(operator.symbol, this);
	}

	@Override
	protected String getSymbol()
	{
		return operator.symbol;
	}
}
