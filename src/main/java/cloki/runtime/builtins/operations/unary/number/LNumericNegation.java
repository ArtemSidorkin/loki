package cloki.runtime.builtins.operations.unary.number;

import cloki.runtime.builtins.operations.unary.LUnaryOperation;
import cloki.runtime.constant.LTypes;
import cloki.runtime.constant.LUnaryOperator;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.number.LNumber;
import cloki.runtime.datatype.number.LNumberPrototype;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;

public class LNumericNegation extends LUnaryOperation<LNumberPrototype>
{
	public static final LNumericNegation instance = new LNumericNegation();

	private LNumericNegation()
	{
		super(LUnaryOperator.MINUS);
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		LNumber hostAsNumber = host.asType(LTypes.NUMBER);

		if (hostAsNumber != null) return new LNumber(-hostAsNumber.getValue());

		LErrors.printErrorUnitDoesNotBelongToType(host, LTypes.NUMBER.getNameWithId());
		return LUndefined.instance;
	}
}
