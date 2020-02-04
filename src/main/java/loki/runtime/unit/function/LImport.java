package loki.runtime.unit.function;

import loki.execution.Execution;
import loki.runtime.constant.LFunctionalUnit;
import loki.runtime.constant.LTypes;
import loki.runtime.unit.LString;
import loki.runtime.unit.LUndefined;
import loki.runtime.unit.LVoid;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;
import loki.runtime.util.Nullable;
import scala.Some;

public class LImport extends LUnit
{
	public static final LImport instance = new LImport();

	private LImport()
	{
		super(new LType(LFunctionalUnit.IMPORT.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		LUnit relativeFilePathNameWithExtensionAsUnit = checkCallParameter(parameters, 0);
		LString relativeFilePathNameWithExtensionAsString =
			relativeFilePathNameWithExtensionAsUnit.asType(LTypes.STRING);

		if (relativeFilePathNameWithExtensionAsString == null)
		{
			LErrors.unitDoesNotBelongToType(relativeFilePathNameWithExtensionAsUnit, LTypes.STRING.getFullName());

			return LUndefined.instance;
		}

		host
			.addParents(
				Execution
					.executor()
					.getModuleInstance(relativeFilePathNameWithExtensionAsString.getValue(), Some.apply(parameters))
			);

		return LVoid.instance;
	}
}
