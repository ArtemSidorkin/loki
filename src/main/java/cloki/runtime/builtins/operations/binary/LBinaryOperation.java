package cloki.runtime.builtins.operations.binary;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;

public abstract class LBinaryOperation<HOST_OPERAND extends LUnit> extends LUnit
{
	protected final LBinaryOperator operator;

	protected LBinaryOperation(LBinaryOperator operator)
	{
		super(new LType(operator.symbol));
		this.operator = operator;
	}

	public void init(HOST_OPERAND hostOperand)
	{
		hostOperand.setMember(operator.symbol, this);
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return execute(host, checkCallParameter(parameters, 0));
	}

	protected abstract LUnit execute(LUnit leftOperand, LUnit rightOperand);

	protected void printErrorUndefinedOperation(LUnit leftOperand, LUnit rightOperand)
	{
		LErrors.printErrorOperatorIsNotDefinedForUnits(operator, leftOperand, rightOperand);
	}
}
