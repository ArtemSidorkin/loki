package cloki.runtime.builtins.units;

import cloki.execution.CExecution;
import cloki.runtime.constant.LFunctionalUnit;
import cloki.runtime.constant.LTypes;
import cloki.runtime.datatype.*;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;
import scala.Some;

public class CInclude extends LUnit
{
	public static final CInclude instance = new CInclude();

	private CInclude()
	{
		super(new LType(LFunctionalUnit.INCLUDE.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		LUnit rltvFlPthNmWthtExtnsnAsUnt = checkCallParameter(parameters, 0);
		LString rltvFlPthNmWthtExtnsnAsStr = rltvFlPthNmWthtExtnsnAsUnt.asType(LTypes.STRING);

		if (rltvFlPthNmWthtExtnsnAsStr == null)
		{
			LErrors.printErrorUnitDoesNotBelongToType(rltvFlPthNmWthtExtnsnAsUnt, LTypes.STRING);
			return LUndefined.instance;
		}

		CExecution.executor().instance().getModule
		(
			rltvFlPthNmWthtExtnsnAsStr.getValue(), Some.apply(unitContext)
		).call
		(
			host, parameters, unitContext
		);

		return LVoid.instance;
	}
}
