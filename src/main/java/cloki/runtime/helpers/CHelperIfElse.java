package cloki.runtime.helpers;

import cloki.runtime.datatypes.CUndefined;
import cloki.runtime.datatypes.CUnit;
import cloki.runtime.datatypes.CVoid;
import cloki.runtime.unitcontexts.CUnitContext;

public abstract class CHelperIfElse
{
	protected CUnit condition;
	protected CUnitContext unitContext;
	protected CUnit callHost;
	protected CUnit[] callParameters;
	protected CUnitContext callUnitContext;

	public CHelperIfElse(CUnit condition, CUnitContext unitContext, CUnit callHost, CUnit[] callParameters, CUnitContext callUnitContext)
	{
		this.condition = condition;
		this.unitContext = unitContext;
		this.callHost = callHost;
		this.callParameters = callParameters;
		this.callUnitContext = callUnitContext;
	}

	public CUnit call()
	{
		return
			condition.toBoolean() ?
			yes(callHost, callParameters, callUnitContext) :
			no(callHost, callParameters, callUnitContext);
	}

	protected abstract CUnit yes(CUnit host, CUnit[] parameters, CUnitContext unitContext);

	protected CUnit no(CUnit host, CUnit[] parameters, CUnitContext unitContext)
	{
		return CVoid.instance;
	}
}
