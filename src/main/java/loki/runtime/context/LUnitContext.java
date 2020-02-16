package loki.runtime.context;

import loki.runtime.LSettings;
import loki.runtime.unit.LUndefined;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.Nullable;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LUnitContext
{
	private final LUnit self;
	private final LUnit host;
	@Nullable private final LUnitContext frameUnitCapturedContext;
	@Nullable private final LUnit[] parameters;

	@Nullable private volatile ConcurrentMap<String, LUnit> variables;

	public LUnitContext(LUnit frameUnit, LUnit host, @Nullable LUnitContext frameUnitCapturedContext, @Nullable LUnit[] parameters)
	{
		this.self = frameUnit;
		this.host = host;
		this.frameUnitCapturedContext = frameUnitCapturedContext;
		this.parameters = parameters;
	}

	public LUnit getSuperVariable(String superVariableName)
	{
		if (frameUnitCapturedContext != null) return frameUnitCapturedContext.getVariable(superVariableName);
		else if (LBuiltins.BUILTINS.containsKey(superVariableName))
			return LBuiltins.BUILTINS.get(superVariableName).get();

		return LUndefined.INSTANCE;
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
			if (variable != LUndefined.INSTANCE) return variable;
		}

		if (self != host) //Is it check needed?
		{
			variable = host.getMember(variableName);
			if (variable != LUndefined.INSTANCE) return variable;
		}

		return getSuperVariable(variableName);
	}

	public LUnit setVariable(String variableName, LUnit variableValue)
	{
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
