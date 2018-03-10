package loki.runtime.builtin.operation;

import loki.runtime.datatype.LType;
import loki.runtime.datatype.LUnit;

public abstract class LOperation<HOST_OPERAND extends LUnit> extends LUnit
{
	protected LOperation(LType type)
	{
		super(type);
	}

	public void init(HOST_OPERAND hostOperand)
	{
		hostOperand.setMember(getSymbol(), this);
	}

	protected abstract String getSymbol();
}
