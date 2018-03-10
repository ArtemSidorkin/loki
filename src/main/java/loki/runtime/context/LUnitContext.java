package loki.runtime.context;

import loki.runtime.LSettings;
import loki.runtime.builtins.LBuiltins;
import loki.runtime.datatype.LUndefined;
import loki.runtime.datatype.LUnit;
import loki.runtime.utils.Nullable;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LUnitContext
{
	private final LUnit self;
	private final LUnit host;
	@Nullable private final LUnitContext parentUnitContext;
	@Nullable private final LUnit[] parameters;
	private final boolean storeVariablesInParent;

	@Nullable private volatile ConcurrentMap<String, LUnit> variables;

	public LUnitContext(LUnit self, LUnit host, @Nullable LUnitContext parentUnitContext, @Nullable LUnit[] parameters)
	{
		this(self, host, parentUnitContext, parameters, false);
	}

	protected LUnitContext(
		LUnit self,
		LUnit host,
		@Nullable LUnitContext parentUnitContext,
		@Nullable LUnit[] parameters,
		boolean storeVariablesInParent
	)
	{
		this.self = self;
		this.host = host;
		this.parentUnitContext = parentUnitContext;
		this.parameters = parameters;
		this.storeVariablesInParent = storeVariablesInParent;
	}

	public LUnit getSuperVariable(String superVariableName)
	{
		if (parentUnitContext != null) return parentUnitContext.getVariable(superVariableName);
		else if (LBuiltins.defaults.containsKey(superVariableName))
			return LBuiltins.defaults.get(superVariableName).get();

		return LUndefined.instance;
	}

	public LUnit getVariable(String variableName)
	{
		LUnit variable;

		if (variables != null)
		{
			variable = variables.get(variableName);
			if (variable != null) return variable;
		}

		if (self != null)
		{
			if (self.getParameterIndexes() != null)
			{
				Integer parameterIndex = self.getParameterIndexes().get(variableName);
				if (parameterIndex != null)
				{
					variable = checkParameter(parameterIndex);
					if (variable != null) return variable;
				}
			}

			variable = self.getMember(variableName);
			if (variable != LUndefined.instance) return variable;
		}

		if (self != host)
		{
			variable = host.getMember(variableName);
			if (variable != LUndefined.instance) return variable;
		}

		return getSuperVariable(variableName);
	}

	public LUnit setVariable(String variableName, LUnit variableValue)
	{
		if (storeVariablesInParent) return parentUnitContext.setVariable(variableName, variableValue);

		initVariablesIfNeeded();
		variables.put(variableName, variableValue);
		return variableValue;
	}

	@Nullable
	private LUnit checkParameter(int parameterIndex)
	{
		if (parameterIndex >= 0 && parameterIndex < parameters.length) return parameters[parameterIndex];
		return null;
	}

	private void initVariablesIfNeeded()
	{
		if (variables == null) synchronized(this)
		{
			if (variables == null)
				variables = new ConcurrentHashMap<> (
					LSettings.CONTEXT_VARIABLES_INITIAL_CAPACITY,
					LSettings.CONTEXT_VARIABLES_LOAD_FACTOR,
					LSettings.CONTEXT_VARIABLES_CONCURRENCY_LEVEL
				);
		}
	}
}
