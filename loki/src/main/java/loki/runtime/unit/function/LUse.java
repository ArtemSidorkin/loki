package loki.runtime.unit.function;

import loki.Executor;
import loki.runtime.unit.data.LString;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

import static loki.runtime.error.LErrors.methodParameterHasWrongType;

public class LUse extends LUnit
{
	private static final int MODULE_FILE_PATHNAME_PARAMETER_INDEX = 0;

	public static final LInstanceDescriptor<LUse> DESCRIPTOR =
		new LInstanceDescriptor<>("use", LUse.class, LUse::new);

	private LUse()
	{
		super(DESCRIPTOR);
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		String moduleFilePathname =
			getParameter(parameters, MODULE_FILE_PATHNAME_PARAMETER_INDEX)
				.asType(
					LString.DESCRIPTOR,
					methodParameterHasWrongType(host, DESCRIPTOR, MODULE_FILE_PATHNAME_PARAMETER_INDEX)
				)
				.getValue();

		LUnit module = Executor.apply(moduleFilePathname);

		if (!host.isType(module.getType())) host.addParents(module);

		return module;
	}
}