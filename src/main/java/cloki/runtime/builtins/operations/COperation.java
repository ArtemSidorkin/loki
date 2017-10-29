package cloki.runtime.builtins.operations;

import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;

public abstract class COperation extends LUnit
{
	protected final LBinaryOperator operator;

	protected COperation(LBinaryOperator operator)
	{
		super(new LType(operator.sign));
		this.operator = operator;
	}

	public void init(LUnit unit) //add generic here
	{
		unit.setMember(operator.sign, this);
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		return execute(host, checkCallParameter(parameters, 0));
	}

	protected abstract LUnit execute(LUnit leftOperand, LUnit rightOperand);

	//operator in parameters? We have it in fealds!!!
	protected void printErrorUndefinedOperation(LBinaryOperator operator, LUnit leftOperand, LUnit rightOperand)
	{
		LErrors.printErrorOperatorIsNotDefinedForUnits(operator, leftOperand, rightOperand); //refactoring is needed
	}
}
