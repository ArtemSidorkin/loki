package cloki.runtime.datatype;

import cloki.runtime.consts.LConstDataUnit;

public class LFalse extends LBoolean
{
	public static final LFalse instance = new LFalse();

	private LFalse()
	{
		super(false);
	}

	@Override
	public String _toString()
	{
		return LConstDataUnit.FALSE.name;
	}
}
