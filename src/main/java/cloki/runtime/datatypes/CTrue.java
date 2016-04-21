package cloki.runtime.datatypes;

import cloki.runtime.consts.CConstDataUnit;

public class CTrue extends CBoolean
{
	public static final CTrue instance = new CTrue();

	private CTrue()
	{
		super(true);
	}

	@Override
	public String _toString()
	{
		return CConstDataUnit.TRUE.name;
	}
}
