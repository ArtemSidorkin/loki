package cloki.runtime.builtins.unaryoperations.number;

import cloki.runtime.builtins.unaryoperations.CUnaryOperation;
import cloki.runtime.constant.LTypes;
import cloki.runtime.constant.LUnaryOperator;
import cloki.runtime.datatype.*;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;

public class CNumericNegation extends CUnaryOperation<LNumberPrototype>
{
	public static final CNumericNegation instance = new CNumericNegation();

	protected CNumericNegation()
	{
		super(LUnaryOperator.MINUS);
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		LNumber nmbrAsNmbr = host.asType(LTypes.NUMBER);
		if (nmbrAsNmbr != null) return new LNumber(-nmbrAsNmbr.getValue());
		LErrors.printErrorUnitDoesNotBelongToType(host, LTypes.NUMBER.getNameWithId());
		return LUndefined.instance;
	}
}
