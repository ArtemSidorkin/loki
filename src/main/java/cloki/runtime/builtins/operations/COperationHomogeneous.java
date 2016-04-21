package cloki.runtime.builtins.operations;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatypes.CNumber;
import cloki.runtime.datatypes.CType;
import cloki.runtime.datatypes.CUndefined;
import cloki.runtime.datatypes.CUnit;

public abstract class COperationHomogeneous<OPERAND extends CUnit> extends COperation
{
	private CType operandType;

	protected COperationHomogeneous(CConstOperator operator, CType operandType)
	{
		super(operator);
		this.operandType = operandType;
	}

	@Override
	protected CUnit execute(CUnit leftOperand, CUnit rightOperand)
	{
		CUnit lftOprndAsNmbr = leftOperand.asType(operandType);
		CUnit rghtOprndAsNmbr = rightOperand.asType(operandType);

		if (lftOprndAsNmbr != null && rghtOprndAsNmbr != null)
			return operation((OPERAND)lftOprndAsNmbr, (OPERAND)rghtOprndAsNmbr);

		printErrorUndefinedOperation(operator, leftOperand, rightOperand);
		return CUndefined.instance;
	}

	protected CUnit operation(OPERAND leftOperand, OPERAND rightOperand)
	{
		printErrorUndefinedOperation(operator, leftOperand, rightOperand);
		return CUndefined.instance;
	}
}
