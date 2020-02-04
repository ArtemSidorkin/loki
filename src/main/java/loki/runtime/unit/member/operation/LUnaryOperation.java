package loki.runtime.unit.member.operation;

import loki.runtime.constant.LUnaryOperator;
import loki.runtime.unit.member.LMember;
import loki.runtime.unit.type.LType;

public abstract class LUnaryOperation extends LMember
{
	protected LUnaryOperation(LUnaryOperator unaryOperator)
	{
		super(new LType(unaryOperator.symbol));
	}
}
