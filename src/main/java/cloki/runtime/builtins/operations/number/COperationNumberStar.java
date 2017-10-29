package cloki.runtime.builtins.operations.number;

import cloki.runtime.consts.CConstOperator;
import cloki.runtime.datatype.LNumber;
import cloki.runtime.datatype.LUnit;

public class COperationNumberStar extends COperationHomogeneousNumber
{
	public static final COperationNumberStar instance = new COperationNumberStar();

	private COperationNumberStar()
	{
		super(CConstOperator.STAR);
	}

	@Override
	protected LUnit operation(LNumber leftOperand, LNumber rightOperand)
	{
		return new LNumber(leftOperand.getValue() * rightOperand.getValue());
	}
}
