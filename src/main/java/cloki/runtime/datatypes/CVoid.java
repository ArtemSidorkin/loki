package cloki.runtime.datatypes;

import cloki.runtime.consts.CConstDataUnit;

public class CVoid extends CUnit
{
	public static final CVoid instance = new CVoid();

	private CVoid()
	{
		super(new CType(CConstDataUnit.VOID.name));
	}
}
