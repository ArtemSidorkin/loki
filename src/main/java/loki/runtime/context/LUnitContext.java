package loki.runtime.context;

import loki.runtime.LSettings;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.Compiler;
import loki.runtime.util.Nullable;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LUnitContext
{
	private final LUnit frameUnit;
	private final LUnit host;
	@Nullable private final LUnit[] parameters;

	@Nullable private final LUnitContext frameUnitCapturedContext;
	@Nullable private volatile ConcurrentMap<String, LUnit> variables;

	@Compiler
	public LUnitContext(LUnit frameUnit, LUnit host, @Nullable LUnit[] parameters)
	{
		this.frameUnit = frameUnit;
		this.host = host;
		this.parameters = parameters;

		frameUnitCapturedContext = this.frameUnit.getCapturedUnitContext();
	}

	public LUnit getSuperVariable(String superVariableName)
	{
		if (frameUnitCapturedContext != null) return frameUnitCapturedContext.getVariable(superVariableName);
		else if (LBuiltins.have(superVariableName)) return LBuiltins.get(superVariableName);

		return LVoid.DESCRIPTOR.getInstance();
	}

	public LUnit getVariable(String variableName)
	{
		LUnit variable;

		if (variables != null)
		{
			variable = variables.get(variableName);
			if (variable != null) return variable;
		}

		if (frameUnit != null)
		{
			if (frameUnit.getParameterIndexes() != null)
			{
				Integer parameterIndex = frameUnit.getParameterIndexes().get(variableName);
				if (parameterIndex != null)
				{
					variable = checkParameter(parameterIndex);
					if (variable != null) return variable;
				}
			}

			variable = frameUnit.getMember(variableName);
			if (variable != LVoid.DESCRIPTOR.getInstance()) return variable;
		}

		if (frameUnit != host) //Is it check needed?
		{
			variable = host.getMember(variableName);
			if (variable != LVoid.DESCRIPTOR.getInstance()) return variable;
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
