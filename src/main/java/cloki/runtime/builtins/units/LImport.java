package cloki.runtime.builtins.units;

import cloki.execution.Execution;
import cloki.runtime.constant.LFunctionalUnit;
import cloki.runtime.constant.LTypes;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.*;
import cloki.runtime.utils.LErrors;
import cloki.runtime.utils.Nullable;
import scala.Some;

public class LImport extends LUnit
{
	public static final LImport instance = new LImport();

	private LImport()
	{
		super(new LType(LFunctionalUnit.IMPORT.name));
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

		host
			.addParent(
				Execution
					.executor()
					.instance()
					.getModuleInstance(relativeFilePathNameWithExtensionAsString.getValue(), Some.apply(parameters))
			);

		return LVoid.instance;
	}
}
