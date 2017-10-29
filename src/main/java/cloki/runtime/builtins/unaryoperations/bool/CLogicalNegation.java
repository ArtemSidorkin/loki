package cloki.runtime.builtins.unaryoperations.bool;

import cloki.runtime.builtins.unaryoperations.CUnaryOperation;
import cloki.runtime.consts.CConstTypes;
import cloki.runtime.consts.CConstUnaryOperator;
import cloki.runtime.datatypes.*;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.Nullable;

public class CLogicalNegation extends CUnaryOperation<CBooleanPrototype>
{
	public static final CLogicalNegation instance = new CLogicalNegation();

	protected CLogicalNegation()
	{
		super(CConstUnaryOperator.BANG);
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		CBoolean blnAsBln = host.asType(CConstTypes.BOOLEAN);
		if (blnAsBln != null) return blnAsBln.getValue() ? CFalse.instance : CTrue.instance;
		else return
		(
			host != CVoid.instance &&
			host != CNone.instance &&
			host != CUndefined.instance &&
			(
				host.asType(CConstTypes.NUMBER) == null ||
				((CNumber)host.asType(CConstTypes.NUMBER)).getValue() != 0
			)
		) ? CFalse.instance : CTrue.instance;
	}
}
