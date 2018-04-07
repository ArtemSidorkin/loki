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

		Execution
			.executor()
			.getModule(relativeFilePathNameWithExtensionAsString.getValue(), Some.apply(unitContext))
			.call(host, parameters, unitContext);

		return LVoid.instance;
	}
}
