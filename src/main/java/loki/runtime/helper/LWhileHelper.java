package loki.runtime.helper;

import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.LVoid;

public abstract class LWhileHelper
{
	protected LUnitContext unitContext;
	protected LUnit callHost;
	protected LUnit[] callParameters;
	protected LUnitContext callUnitContext;

	public LWhileHelper(LUnitContext unitContext, LUnit callHost, LUnit[] callParameters, LUnitContext callUnitContext)
	{
		this.unitContext = unitContext;
		this.callHost = callHost;
		this.callParameters = callParameters;
		this.callUnitContext = callUnitContext;
	}

	public LUnit call()
	{
		while (condition(callHost, callParameters, callUnitContext).toBoolean())
			action(callHost, callParameters, callUnitContext);

		return LVoid.instance;
	}

	protected abstract LUnit condition(LUnit host, LUnit[] parameters, LUnitContext unitContext);

	protected abstract LUnit action(LUnit host, LUnit[] parameters, LUnitContext unitContext);
}
