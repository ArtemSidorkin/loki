package loki.runtime.unit.unit.member.operation.binary;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.member.operation.LBinaryOperation;
import loki.runtime.unit.unit.LUnit;

public abstract class LUnitBinaryOperation extends LBinaryOperation<LUnit, LUnit>
{
	protected LUnitBinaryOperation(LBinaryOperator operator)
	{
		super(operator);
	}
}
