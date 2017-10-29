package cloki.runtime.builtins.units;

import cloki.execution.CExecution;
import cloki.runtime.constant.LFunctionalUnit;
import cloki.runtime.constant.LTypes;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.*;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;
import scala.Some;

public class LInclude extends LUnit
{
	public static final LInclude instance = new LInclude();

	private LInclude()
	{
		super(new LType(LFunctionalUnit.INCLUDE.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters, @Nullable LUnitContext unitContext)
	{
		LUnit relativeFilePathNameWithExtensionAsUnit = checkCallParameter(parameters, 0);
		LString relativeFilePathNameWithExtensionAsString =
			relativeFilePathNameWithExtensionAsUnit.asType(LTypes.STRING);

		if (relativeFilePathNameWithExtensionAsString == null)
		{
			LErrors.printErrorUnitDoesNotBelongToType(relativeFilePathNameWithExtensionAsUnit, LTypes.STRING);
			return LUndefined.instance;
		}

		CExecution
			.executor()
			.instance()
			.getModule(relativeFilePathNameWithExtensionAsString.getValue(), Some.apply(unitContext))
			.call(host, parameters, unitContext);

		return LVoid.instance;
	}
}
