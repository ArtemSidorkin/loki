package loki.runtime.builtin.operation.unary;

import loki.runtime.builtin.operation.LOperation;
import loki.runtime.constant.LUnaryOperator;
import loki.runtime.datatype.LType;
import loki.runtime.datatype.LUnit;

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
