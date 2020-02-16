package loki.runtime.unit.function;

import loki.execution.Execution;
import loki.runtime.constant.LTypes;
import loki.runtime.unit.LString;
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
		LUnit moduleFilePathnameAsUnit = checkCallParameter(parameters, 0);
		LString moduleFilePathnameAsString = moduleFilePathnameAsUnit.asType(LTypes.STRING);

		if (moduleFilePathnameAsString == null)
		{
			LErrors.unitShouldHaveType(moduleFilePathnameAsUnit, LTypes.STRING.getFullName());

			return null;
		}

		LUnit module = Execution.executor().getModuleInstance(moduleFilePathnameAsString.getValue());

		if (!host.isType(module.getType())) host.addParents(module);

		return module;
	}
}