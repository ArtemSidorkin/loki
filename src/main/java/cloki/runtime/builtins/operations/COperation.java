package cloki.runtime.builtins.operations;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.CErrors;
import cloki.runtime.utils.Nullable;

public abstract class COperation extends CUnit
{
	protected final CConstOperator operator;

	protected COperation(CConstOperator operator)
	{
		super(new CType(operator.sign));
		this.operator = operator;
	}

	public void init(CUnit unit) //add generic here
	{
		unit.setMember(operator.sign, this);
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		return execute(host, checkCallParameter(parameters, 0));
	}

	protected abstract CUnit execute(CUnit leftOperand, CUnit rightOperand);

	//operator in parameters? We have it in fealds!!!
	protected void printErrorUndefinedOperation(CConstOperator operator, CUnit leftOperand, CUnit rightOperand)
	{
		CErrors.printErrorOperatorIsNotDefinedForUnits(operator, leftOperand, rightOperand); //refactoring is needed
	}
}
