package loki.runtime.context;

import loki.runtime.LSettings;
import loki.runtime.compilerapi.unitcontext.UnitContextConstructor;
import loki.runtime.compilerapi.unitcontext.UnitContextGetAnonymousParameter;
import loki.runtime.compilerapi.unitcontext.UnitContextGetVariable;
import loki.runtime.compilerapi.unitcontext.UnitContextSetVariable;
import loki.runtime.unit.LModule;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.util.Nullable;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LUnitContext
{
	private final LUnit frameUnit;
	private final LUnit host;
	private final LUnit[] parameters;

	private final AtomicInteger anonymousParameterIndex = new AtomicInteger(0);

	private volatile @Nullable ConcurrentMap<String, LUnit> localVariables;

	@UnitContextConstructor
	public LUnitContext(LUnit frameUnit, LUnit host, LUnit[] parameters)
	{
		this.frameUnit = frameUnit;
		this.host = host;
		this.parameters = parameters;
	}

	@UnitContextGetAnonymousParameter
	public LUnit getAnonymousParameter()
	{
		LUnit anonymousParameter = checkParameter(anonymousParameterIndex.getAndIncrement());

		return anonymousParameter != null ? anonymousParameter : LVoid.DESCRIPTOR.getInstance();
	}

	@UnitContextGetVariable
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

	@UnitContextSetVariable
	public LUnit setVariable(String variableName, LUnit variableValue)
	{
		initVariablesIfNecessary().put(variableName, variableValue);

		return variableValue;
	}

	public LUnit getSuperVariable(String superVariableName)
	{
		if (frameUnit.getCapturedUnitContext() != null)
			return frameUnit.getCapturedUnitContext().getVariable(superVariableName);
		else if (LBuiltins.contain(superVariableName)) return LBuiltins.get(superVariableName);

		return LVoid.DESCRIPTOR.getInstance();
	}

	private @Nullable LUnit getLocalVariable(String localVariableName)
	{
		if (localVariables == null) return null;

		return localVariables.get(localVariableName);
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
		if (parameterIndex == null || parameterIndex < 0) return null;

		if (parameterIndex < parameters.length)	return parameters[parameterIndex];

		if (
			frameUnit.getParameterDefaultValues() != null &&
			parameterIndex < frameUnit.getParameterDefaultValues().length
		)
			return frameUnit.getParameterDefaultValues()[parameterIndex];

		return null;
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
