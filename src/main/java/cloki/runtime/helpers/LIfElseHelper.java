package cloki.runtime.helpers;

import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.datatype.LVoid;

public abstract class LIfElseHelper
{
	protected LUnit condition;
	protected LUnitContext unitContext;
	protected LUnit callHost;
	protected LUnit[] callParameters;
	protected LUnitContext callUnitContext;

	public LIfElseHelper(
		LUnit condition, LUnitContext unitContext, LUnit callHost, LUnit[] callParameters, LUnitContext callUnitContext
	)
	{
		this.condition = condition;
		this.unitContext = unitContext;
		this.callHost = callHost;
		this.callParameters = callParameters;
		this.callUnitContext = callUnitContext;
	}

	public LUnit call()
	{
		return
			condition.toBoolean()
				? yes(callHost, callParameters, callUnitContext)
				: no(callHost, callParameters, callUnitContext);
	}

	protected abstract LUnit yes(LUnit host, LUnit[] parameters, LUnitContext unitContext);

	protected LUnit no(LUnit host, LUnit[] parameters, LUnitContext unitContext)
	{
		return LVoid.instance;
	}
}
