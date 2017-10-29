package cloki.runtime.builtins.units;

import cloki.execution.CExecution;
import cloki.runtime.constant.LFunctionalUnit;
import cloki.runtime.constant.LTypes;
import cloki.runtime.datatype.*;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;
import scala.Some;

public class CImport extends LUnit
{
	public static final CImport instance = new CImport();

	private CImport()
	{
		super(new LType(LFunctionalUnit.IMPORT.name));
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

		host.addParent
		(
			CExecution.executor().instance().getModuleInstance
			(
				rltvFlPthNmWthtExtnsnAsStr.getValue(), Some.apply(parameters)
			)
		);

		return LVoid.instance;
	}
}
