package cloki.runtime.builtins.operations;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;

public abstract class COperationHomogeneous<OPERAND extends LUnit> extends COperation
{
	private LType operandType;

	protected COperationHomogeneous(CConstOperator operator, LType operandType)
	{
		super(operator);
		this.operandType = operandType;
	}

	@Override
	protected LUnit execute(LUnit leftOperand, LUnit rightOperand)
	{
		LUnit lftOprndAsNmbr = leftOperand.asType(operandType);
		LUnit rghtOprndAsNmbr = rightOperand.asType(operandType);

		if (lftOprndAsNmbr != null && rghtOprndAsNmbr != null)
			return operation((OPERAND)lftOprndAsNmbr, (OPERAND)rghtOprndAsNmbr);

		printErrorUndefinedOperation(operator, leftOperand, rightOperand);
		return LUndefined.instance;
	}

	protected LUnit operation(OPERAND leftOperand, OPERAND rightOperand)
	{
		printErrorUndefinedOperation(operator, leftOperand, rightOperand);
		return LUndefined.instance;
	}
}
