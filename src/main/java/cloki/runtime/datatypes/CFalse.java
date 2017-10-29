package cloki.runtime.datatypes;

import cloki.runtime.consts.CConstDataUnit;

public class CFalse extends CBoolean
{
	public static final CFalse instance = new CFalse();

	private CFalse()
	{
		super(false);
	}

	@Override
	public String _toString()
	{
		return CConstDataUnit.FALSE.name;
	}
}
