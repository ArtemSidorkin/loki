package loki.runtime.unit.function;

import loki.execution.Execution;
import loki.runtime.unit.LString;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.LErrors;

public class LUse extends LUnit
{
	public static final String TYPE_NAME = "use";
	public static final LType TYPE = new LType(TYPE_NAME, LUse.class);

	public static final LUse INSTANCE = new LUse();

	private LUse()
	{
		super(TYPE);
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		LUnit moduleFilePathnameAsUnit = checkCallParameter(parameters, 0);
		LString moduleFilePathnameAsString = moduleFilePathnameAsUnit.asType(LString.TYPE);

		if (moduleFilePathnameAsString == null)
		{
			LErrors.operandShouldHaveType(moduleFilePathnameAsUnit, LString.TYPE);

			return null;
		}

		LUnit module = Execution.executor().getModuleInstance(moduleFilePathnameAsString.getValue());

		if (!host.isType(module.getType())) host.addParents(module);

		return module;
	}
}