package loki.runtime.context;

import loki.runtime.LBuiltins;
import loki.runtime.marker.Nullable;
import loki.runtime.marker.compilerapi.unitcontext.UnitContextConstructor;
import loki.runtime.marker.compilerapi.unitcontext.UnitContextGetAnonymousParameter;
import loki.runtime.marker.compilerapi.unitcontext.UnitContextGetVariable;
import loki.runtime.marker.compilerapi.unitcontext.UnitContextSetVariable;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LUnitContext
{
	private static final int LOCAL_VARIABLES_INITIAL_CAPACITY = 8;
	private static final float LOCAL_VARIABLES_LOAD_FACTOR = 0.75f;
	private static final int LOCAL_VARIABLES_CONCURRENCY_LEVEL = 1;

	private final LUnit frame;
	private final LUnit host;
	private final LUnit[] parameters;

	private volatile @Nullable AtomicInteger anonymousParameterIndex;
	private volatile @Nullable ConcurrentMap<String, LUnit> localVariables;

	@UnitContextConstructor
	public LUnitContext(LUnit frame, LUnit host, LUnit... parameters)
	{
		this.frame = frame;
		this.host = host;
		this.parameters = parameters;
	}

	@UnitContextGetAnonymousParameter
	public LUnit getAnonymousParameter()
	{
		LUnit parameter = getParameter(initAnonymousParameterIndex().getAndIncrement());

		if (parameter != null) return parameter;

		return LVoid.getInstance();
	}

	@UnitContextGetVariable
	public LUnit getVariable(String variableName)
	{
		LUnit variable = getLocalVariable(variableName);

		if (variable != null) return variable;

		variable = getParameter(variableName);

		if (variable != null) return variable;

		variable = getHostMember(variableName);

		if (variable != null) return variable;

		variable = getSuperVariable(variableName);

		if (variable != null) return variable;

		return LVoid.getInstance();
	}

	@UnitContextSetVariable
	public LUnit setVariable(String variableName, LUnit variableValue)
	{
		initLocalVariables().put(variableName, variableValue);

		return variableValue;
	}

	private @Nullable LUnit getSuperVariable(String superVariableName)
	{
		if (frame.getCapturedUnitContext() != null)
		{
			LUnit superVariable = frame.getCapturedUnitContext().getVariable(superVariableName);

			if (superVariable != null) return superVariable;
		}

		return LBuiltins.get(superVariableName);
	}

	private @Nullable LUnit getLocalVariable(String localVariableName)
	{
		if (localVariables == null) return null;

		return localVariables.get(localVariableName);
	}

	private @Nullable LUnit getParameter(String parameterName)
	{
		Integer parameterIndex = frame.getParameterIndexes().get(parameterName);

		if (parameterIndex != null) return getParameter(parameterIndex);

		return null;
	}

	private @Nullable LUnit getHostMember(String hostMemberName)
	{
		LUnit hostMember = host.getMember(hostMemberName);

		if (!LVoid.isTypeOf(hostMember)) return hostMember;

		return null;
	}

	private @Nullable LUnit getParameter(int parameterIndex)
	{
		return parameterIndex < parameters.length ? parameters[parameterIndex] : getDefaultParameter(parameterIndex);
	}

	private @Nullable LUnit getDefaultParameter(int parameterIndex)
	{
		if (parameterIndex >= frame.getParameterDefaultValues().length) return null;

		return frame.getParameterDefaultValues()[parameterIndex];
	}

	private ConcurrentMap<String, LUnit> initLocalVariables()
	{
		if (localVariables == null) synchronized(this)
		{
			if (localVariables == null)
				localVariables =
					new ConcurrentHashMap<>(
						LOCAL_VARIABLES_INITIAL_CAPACITY, LOCAL_VARIABLES_LOAD_FACTOR, LOCAL_VARIABLES_CONCURRENCY_LEVEL
					);
		}

		return localVariables;
	}

	private AtomicInteger initAnonymousParameterIndex()
	{
		if (anonymousParameterIndex == null) synchronized(this)
		{
			if (anonymousParameterIndex == null) anonymousParameterIndex = new AtomicInteger();
		}

		return anonymousParameterIndex;
	}
}
