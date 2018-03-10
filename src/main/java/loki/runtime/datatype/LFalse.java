package loki.runtime.datatype;

import loki.runtime.constant.LDataUnit;

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
		return LDataUnit.FALSE.name;
	}
}
