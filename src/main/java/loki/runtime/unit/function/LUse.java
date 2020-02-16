package loki.runtime.unit.function;

import loki.execution.Execution;
import loki.runtime.constant.LTypes;
import loki.runtime.unit.LString;
import loki.runtime.unit.LUndefined;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;

public class LUse extends LUnit
{
	public static final String NAME = "USE";
	public static final LUse INSTANCE = new LUse();

	private LUse()
	{
		super(new LType(NAME));
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		LUnit unitModuleFilePathname = checkCallParameter(parameters, 0);
		LString stringModuleFilePathname = unitModuleFilePathname.asType(LTypes.STRING);

		if (stringModuleFilePathname == null)
		{
			LErrors.unitDoesNotBelongToType(unitModuleFilePathname, LTypes.STRING.getFullName());

			return LUndefined.INSTANCE;
		}

		LUnit module = Execution.executor().getModuleInstance(stringModuleFilePathname.getValue());

		if (host.asType(module.getType()) == null) host.addParents(module);

		return module;
	}
}