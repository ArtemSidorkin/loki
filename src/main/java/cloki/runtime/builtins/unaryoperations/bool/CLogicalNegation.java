package cloki.runtime.builtins.unaryoperations.bool;

import cloki.runtime.builtins.unaryoperations.CUnaryOperation;
import cloki.runtime.constant.LTypes;
import cloki.runtime.constant.LUnaryOperator;
import cloki.runtime.datatype.*;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

public class CLogicalNegation extends CUnaryOperation<LBooleanPrototype>
{
	public static final CLogicalNegation instance = new CLogicalNegation();

	protected CLogicalNegation()
	{
		super(LUnaryOperator.BANG);
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		LBoolean blnAsBln = host.asType(LTypes.BOOLEAN);
		if (blnAsBln != null) return blnAsBln.getValue() ? LFalse.instance : LTrue.instance;
		else return
		(
			host != LVoid.instance &&
			host != LNone.instance &&
			host != LUndefined.instance &&
			(
				host.asType(LTypes.NUMBER) == null ||
				((LNumber)host.asType(LTypes.NUMBER)).getValue() != 0
			)
		) ? LFalse.instance : LTrue.instance;
	}
}
