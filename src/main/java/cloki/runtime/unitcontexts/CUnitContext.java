package cloki.runtime.unitcontexts;

import cloki.runtime.CSettings;
import cloki.runtime.builtins.CBuiltins;
import cloki.runtime.datatypes.CUndefined;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.utils.Nullable;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CUnitContext
{
	private final CUnit self;
	private final CUnit host;
	@Nullable private final CUnitContext parentUnitContext;
	@Nullable private final CUnit[] parameters;
	private final boolean storeVariablesInParent;
	@Nullable private volatile ConcurrentMap<String, CUnit> variables;

	public CUnitContext(CUnit self, CUnit host, @Nullable CUnitContext parentUnitContext, @Nullable CUnit[] parameters)
	{
		this(self, host, parentUnitContext, parameters, false);
	}

	protected CUnitContext
	(
		CUnit self,
		CUnit host,
		@Nullable CUnitContext parentUnitContext,
		@Nullable CUnit[] parameters,
		boolean storeVariablesInParent
	)
	{
		this.self = self;
		this.host = host;
		this.parentUnitContext = parentUnitContext;
		this.parameters = parameters;
		this.storeVariablesInParent = storeVariablesInParent;
	}

	public CUnit getSuperVariable(String superVariableName)
	{
		if (parentUnitContext != null) return parentUnitContext.getVariable(superVariableName);
		else if (CBuiltins.defaults.containsKey(superVariableName))
			return CBuiltins.defaults.get(superVariableName).get();

		return CUndefined.instance;
	}

	public CUnit getVariable(String variableName)
	{
		CUnit vrbl;

		if (variables != null)
		{
			vrbl = variables.get(variableName);
			if (vrbl != null) return vrbl;
		}

		if (self != null)
		{
			if (self.getParameters() != null)
			{
				Integer indx = self.getParameters().get(variableName);
				if (indx != null)
				{
					vrbl = checkParameter(indx);
					if (vrbl != null) return vrbl;
				}
			}

			vrbl = self.getMember(variableName);
			if (vrbl != CUndefined.instance) return vrbl;
		}

		if (self != host)
		{
			vrbl = host.getMember(variableName);
			if (vrbl != CUndefined.instance) return vrbl;
		}

		return getSuperVariable(variableName);
	}

	public CUnit setVariable(String variableName, CUnit variable)
	{
		if (storeVariablesInParent) return parentUnitContext.setVariable(variableName, variable);

		initVariablesIfNeeded();
		variables.put(variableName, variable);
		return variable;
	}

	@Nullable
	private CUnit checkParameter(int parameterIndex)
	{
		if (parameterIndex >= 0 && parameterIndex < parameters.length) return parameters[parameterIndex];
		return null;
	}

	private void initVariablesIfNeeded()
	{
		if (variables == null) synchronized(this)
		{
			if (variables == null) variables = new ConcurrentHashMap<>
			(
				CSettings.CONTEXT_VARIABLES_INITIAL_CAPACITY,
				CSettings.CONTEXT_VARIABLES_LOAD_FACTOR,
				CSettings.CONTEXT_VARIABLES_CONCURRENCY_LEVEL
			);
		}
	}
}
