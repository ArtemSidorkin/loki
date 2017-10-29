package cloki.runtime.datatype;

import cloki.runtime.consts.LConstDataUnit;

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
		return LConstDataUnit.TRUE.name;
	}
}
