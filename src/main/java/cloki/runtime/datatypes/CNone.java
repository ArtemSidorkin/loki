package cloki.runtime.datatypes;

import cloki.runtime.consts.CConstDataUnit;

public class CNone extends CUnit
{
	public static final CNone instance = new CNone();

	private CNone()
	{
		super(new CType(CConstDataUnit.NONE.name));
	}
}
