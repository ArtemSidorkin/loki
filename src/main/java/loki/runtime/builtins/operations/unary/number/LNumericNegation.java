package loki.runtime.builtins.operations.unary.number;

import loki.runtime.builtins.operations.unary.LUnaryOperation;
import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnaryOperator;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.number.LNumberPrototype;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.utils.LErrors;
import loki.runtime.utils.Nullable;

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
