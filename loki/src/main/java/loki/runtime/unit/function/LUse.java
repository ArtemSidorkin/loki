package loki.runtime.unit.function;

import loki.Executor;
import loki.runtime.unit.data.LString;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;
import loki.runtime.error.LErrors;

public class LUse extends LUnit
{
	public static final LInstanceUnitDescriptor<LUse> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("use", LUse.class, LUse::new);

	private LUse()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters)
	{
		LUnit moduleFilePathnameAsUnit = checkCallParameter(parameters, 0);
		LString moduleFilePathnameAsString = moduleFilePathnameAsUnit.asType(LString.DESCRIPTOR.getType());

		if (moduleFilePathnameAsString == null)
		{
			LErrors.operandShouldHaveType(moduleFilePathnameAsUnit, LString.DESCRIPTOR.getType());

			return null;
		}

		LUnit module = Executor.getModule(moduleFilePathnameAsString.getValue());

		if (!host.isType(module.getType())) host.addParents(module);

		return module;
	}
}