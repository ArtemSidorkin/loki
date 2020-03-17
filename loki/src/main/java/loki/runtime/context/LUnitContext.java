package loki.runtime.context;

import loki.runtime.LSettings;
import loki.runtime.unit.LModule;
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
	private final LUnit[] parameters;

	private volatile @Nullable ConcurrentMap<String, LUnit> localVariables;

	@Compiler
	public LUnitContext(LUnit frameUnit, LUnit host, LUnit[] parameters)
	{
		this.frameUnit = frameUnit;
		this.host = host;
		this.parameters = parameters;
	}

	@Compiler
	public LUnit getVariable(String variableName)
	{
		LUnit variable;

		variable = getLocalVariable(variableName);
		if (variable != null) return variable;

		variable = getParameter(variableName);
		if (variable != null) return variable;

		variable = getHostMember(variableName);
		if (variable != null) return variable;

		return getSuperVariable(variableName);
	}

	@Compiler
	public LUnit setVariable(String variableName, LUnit variableValue)
	{
		initVariablesIfNecessary().put(variableName, variableValue);;

		return variableValue;
	}

	public LUnit getSuperVariable(String superVariableName)
	{
		if (frameUnit.getCapturedUnitContext() != null)
			return frameUnit.getCapturedUnitContext().getVariable(superVariableName);
		else if (LBuiltins.have(superVariableName)) return LBuiltins.get(superVariableName);

		return LVoid.DESCRIPTOR.getInstance();
	}

	private @Nullable LUnit getLocalVariable(String localVariableName)
	{
		if (localVariables == null) return null;

		LUnit variable = localVariables.get(localVariableName);

		if (variable == null) return null;

		return variable;
	}

	private @Nullable LUnit getParameter(String parameterName)
	{
		if (frameUnit.getParameterIndexes() == null) return null;

		return checkParameter(frameUnit.getParameterIndexes().get(parameterName));
	}

	private @Nullable LUnit getHostMember(String hostMemberName)
	{
		if (host instanceof LModule && host != frameUnit) return null;

		LUnit variable = host.getMember(hostMemberName);

		if (variable == LVoid.DESCRIPTOR.getInstance()) return null;

		return variable;
	}

	private @Nullable LUnit checkParameter(@Nullable Integer parameterIndex)
	{
		if (parameterIndex == null || parameterIndex < 0 || parameterIndex >= parameters.length) return null;

		return parameters[parameterIndex];
	}

	private ConcurrentMap<String, LUnit> initVariablesIfNecessary()
	{
		if (localVariables == null) synchronized(this)
		{
			if (localVariables == null)
				localVariables =
					new ConcurrentHashMap<> (
						LSettings.CONTEXT_VARIABLES_INITIAL_CAPACITY,
						LSettings.CONTEXT_VARIABLES_LOAD_FACTOR,
						LSettings.CONTEXT_VARIABLES_CONCURRENCY_LEVEL
					);
		}

		return localVariables;
	}
}