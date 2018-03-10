package loki.runtime.builtins.units;

import loki.execution.Execution;
import loki.runtime.constant.LFunctionalUnit;
import loki.runtime.constant.LTypes;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.*;
import loki.runtime.utils.LErrors;
import loki.runtime.utils.Nullable;
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
					.getModuleInstance(relativeFilePathNameWithExtensionAsString.getValue(), Some.apply(parameters))
			);

		return LVoid.instance;
	}
}
