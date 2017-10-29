package cloki.runtime.datatype;

import cloki.runtime.constant.LDataUnit;

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
