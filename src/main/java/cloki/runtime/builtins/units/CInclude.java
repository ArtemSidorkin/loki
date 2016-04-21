package cloki.runtime.builtins.units;

import cloki.execution.CExecution;
import cloki.runtime.consts.CConstFunctionalUnit;
import cloki.runtime.consts.CConstTypes;
import cloki.runtime.datatypes.*;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.CErrors;
import cloki.runtime.utils.Nullable;
import scala.Some;

public class CInclude extends CUnit
{
	public static final CInclude instance = new CInclude();

	private CInclude()
	{
		super(new CType(CConstFunctionalUnit.INCLUDE.name));
	}

	@Override
	public CUnit call(CUnit host, @Nullable CUnit[] parameters, @Nullable CUnitContext unitContext)
	{
		CUnit rltvFlPthNmWthtExtnsnAsUnt = checkCallParameter(parameters, 0);
		CString rltvFlPthNmWthtExtnsnAsStr = rltvFlPthNmWthtExtnsnAsUnt.asType(CConstTypes.STRING);

		if (rltvFlPthNmWthtExtnsnAsStr == null)
		{
			CErrors.printErrorUnitDoesNotBelongToType(rltvFlPthNmWthtExtnsnAsUnt, CConstTypes.STRING);
			return CUndefined.instance;
		}

		CExecution.executor().instance().getModule
		(
			rltvFlPthNmWthtExtnsnAsStr.getValue(), Some.apply(unitContext)
		).call
		(
			host, parameters, unitContext
		);

		return CVoid.instance;
	}
}
