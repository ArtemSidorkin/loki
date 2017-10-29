package cloki.runtime.helpers;

import cloki.runtime.datatypes.CUndefined;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.datatypes.CVoid;
import cloki.runtime.unitcontexts.CUnitContext;

public abstract class CHelperWhile
{
	protected CUnitContext unitContext;
	protected CUnit callHost;
	protected CUnit[] callParameters;
	protected CUnitContext callUnitContext;

	public CHelperWhile(CUnitContext unitContext, CUnit callHost, CUnit[] callParameters, CUnitContext callUnitContext)
	{
		this.unitContext = unitContext;
		this.callHost = callHost;
		this.callParameters = callParameters;
		this.callUnitContext = callUnitContext;
	}

	public CUnit call()
	{
		while (condition(callHost, callParameters, callUnitContext).toBoolean())
			action(callHost, callParameters, callUnitContext);
		return CVoid.instance;
	}

	protected abstract CUnit condition(CUnit host, CUnit[] parameters, CUnitContext unitContext);

	protected abstract CUnit action(CUnit host, CUnit[] parameters, CUnitContext unitContext);
}
