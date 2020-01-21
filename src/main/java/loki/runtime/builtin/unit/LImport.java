package loki.runtime.builtin.unit;

import loki.execution.Execution;
import loki.runtime.constant.LFunctionalUnit;
import loki.runtime.constant.LTypes;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LString;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.LVoid;
import loki.runtime.datatype.type.LType;
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
			LErrors.unitDoesNotBelongToType(relativeFilePathNameWithExtensionAsUnit, LTypes.STRING);
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
