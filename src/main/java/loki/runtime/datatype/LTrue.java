package loki.runtime.datatype;

import loki.runtime.constant.LDataUnit;

public class LTrue extends LBoolean
{
	public static final LTrue instance = new LTrue();

	private LTrue()
	{
		super(true);
	}

	@Override
	public String _toString()
	{
		return LDataUnit.TRUE.name;
	}
}
