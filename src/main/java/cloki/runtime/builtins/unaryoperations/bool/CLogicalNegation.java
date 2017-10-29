package cloki.runtime.builtins.unaryoperations.bool;

import cloki.runtime.builtins.unaryoperations.CUnaryOperation;
import cloki.runtime.consts.CConstTypes;
import cloki.runtime.consts.CConstUnaryOperator;
import cloki.runtime.datatype.*;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.Nullable;

public class CLogicalNegation extends CUnaryOperation<LBooleanPrototype>
{
	public static final CLogicalNegation instance = new CLogicalNegation();

	protected CLogicalNegation()
	{
		super(CConstUnaryOperator.BANG);
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		LBoolean blnAsBln = host.asType(CConstTypes.BOOLEAN);
		if (blnAsBln != null) return blnAsBln.getValue() ? LFalse.instance : LTrue.instance;
		else return
		(
			host != LVoid.instance &&
			host != LNone.instance &&
			host != LUndefined.instance &&
			(
				host.asType(CConstTypes.NUMBER) == null ||
				((LNumber)host.asType(CConstTypes.NUMBER)).getValue() != 0
			)
		) ? LFalse.instance : LTrue.instance;
	}
}
