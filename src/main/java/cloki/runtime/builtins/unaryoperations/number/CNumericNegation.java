package cloki.runtime.builtins.unaryoperations.number;

import cloki.runtime.builtins.unaryoperations.CUnaryOperation;
import cloki.runtime.consts.CConstTypes;
import cloki.runtime.consts.CConstUnaryOperator;
import cloki.runtime.datatypes.*;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.CErrors;
import cloki.runtime.utils.Nullable;

public class CNumericNegation extends CUnaryOperation<CNumberPrototype>
{
	public static final CNumericNegation instance = new CNumericNegation();

	protected CNumericNegation()
	{
		super(CConstUnaryOperator.MINUS);
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		CNumber nmbrAsNmbr = host.asType(CConstTypes.NUMBER);
		if (nmbrAsNmbr != null) return new CNumber(-nmbrAsNmbr.getValue());
		CErrors.printErrorUnitDoesNotBelongToType(host, CConstTypes.NUMBER.getNameWithId());
		return CUndefined.instance;
	}
}
