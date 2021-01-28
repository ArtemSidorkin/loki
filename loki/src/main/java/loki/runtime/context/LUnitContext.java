package loki.runtime.context;

import loki.runtime.marker.Nullable;
import loki.runtime.marker.compilerapi.unitcontext.UnitContextConstructor;
import loki.runtime.marker.compilerapi.unitcontext.UnitContextGetAnonymousParameter;
import loki.runtime.marker.compilerapi.unitcontext.UnitContextGetVariable;
import loki.runtime.marker.compilerapi.unitcontext.UnitContextSetVariable;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.unit.LUnit;

import java.util.Optional;
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
	public LUnitContext(LUnit frame, LUnit host, LUnit[] parameters)
	{
		this.frame = frame;
		this.host = host;
		this.parameters = parameters;
	}

	@UnitContextGetAnonymousParameter
	public LUnit getAnonymousParameter()
	{
		return getParameter(initAnonymousParameterIndex().getAndIncrement()).orElseGet(LVoid::getInstance);
	}

	@UnitContextGetVariable
	public LUnit getVariable(String variableName)
	{
		return getLocalVariable(variableName)
			.or(() -> getParameter(variableName))
			.or(() -> getHostMember(variableName))
			.or(() -> getSuperVariable(variableName))
			.orElseGet(LVoid::getInstance);
	}

	@UnitContextSetVariable
	public LUnit setVariable(String variableName, LUnit variableValue)
	{
		initLocalVariables().put(variableName, variableValue);

		return variableValue;
	}

	private Optional<LUnit> getSuperVariable(String superVariableName)
	{
		return frame
			.getOptionalCapturedUnitContext()
			.map(context -> context.getVariable(superVariableName))
			.or(() -> LBuiltins.get(superVariableName));
	}

	private Optional<LUnit> getLocalVariable(String localVariableName)
	{
		return getLocalVariables().map(localVariables -> localVariables.get(localVariableName));
	}

	private Optional<LUnit> getParameter(String parameterName)
	{
		return Optional.ofNullable(frame.getParameterIndexes().get(parameterName)).flatMap(this::getParameter);
	}

	private Optional<LUnit> getHostMember(String hostMemberName)
	{
		return Optional.of(host).map(host -> host.getMember(hostMemberName)).filter(LVoid::isNotTypeOf);
	}

	private Optional<LUnit> getParameter(int parameterIndex)
	{
		return parameterIndex < parameters.length
			? Optional.of(parameters[parameterIndex])
			: getDefaultParameter(parameterIndex);
	}

	private Optional<LUnit> getDefaultParameter(int parameterIndex)
	{
		if (parameterIndex >= frame.getParameterDefaultValues().length) return Optional.empty();

		return Optional.ofNullable(frame.getParameterDefaultValues()[parameterIndex]);
	}

	private Optional<ConcurrentMap<String, LUnit>> getLocalVariables()
	{
		return Optional.ofNullable(localVariables);
	}

	private ConcurrentMap<String, LUnit> initLocalVariables()
	{
		if (localVariables == null) synchronized(this)
		{
			if (localVariables == null)
				localVariables =
					new ConcurrentHashMap<> (
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
