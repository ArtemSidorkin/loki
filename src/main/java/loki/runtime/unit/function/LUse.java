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

public class LUse extends LUnit
{
	public static final LUse instance = new LUse();

	private LUse()
	{
		super(new LType(LFunctionalUnit.USE.name));
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

		LUnit module = Execution.executor().getModuleInstance(relativeFilePathNameWithExtensionAsString.getValue());

		if (host.asType(module.getType()) == null) host.addParents(module);

		return LVoid.INSTANCE;
	}
}
