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
import scala.Option;

public class LInclude extends LUnit
{
	public static final LInclude instance = new LInclude();

	private LInclude()
	{
		super(new LType(LFunctionalUnit.INCLUDE.name));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		LUnit relativeFilePathNameWithExtensionAsUnit = checkCallParameter(parameters, 0);
		LString relativeFilePathNameWithExtensionAsString =
			relativeFilePathNameWithExtensionAsUnit.asType(LTypes.STRING);

		if (relativeFilePathNameWithExtensionAsString == null)
		{
			LErrors.unitDoesNotBelongToType(relativeFilePathNameWithExtensionAsUnit, LTypes.STRING.getFullName());

			return LUndefined.INSTANCE;
		}

		Execution
			.executor()
			.getModule(relativeFilePathNameWithExtensionAsString.getValue(), Option.apply(null))
			.call(host, parameters);

		return LVoid.INSTANCE;
	}
}
