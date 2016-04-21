package cloki.runtime.consts;

import cloki.runtime.datatypes.CType;

public class CConstTypes
{
	public static final CType BOOLEAN_PROTOTYPE = new CType(CConstDataUnit.BOOLEAN_PROTOTYPE.name);
	public static final CType BOOLEAN = new CType(CConstType.BOOLEAN.name);

	public static final CType NUMBER_PROTOTYPE = new CType(CConstDataUnit.NUMBER_PROTOTYPE.name);
	public static final CType NUMBER = new CType(CConstType.NUMBER.name);

	public static final CType STRING_PROTOTYPE = new CType(CConstDataUnit.STRING_PROTOTYPE.name);
	public static final CType STRING = new CType(CConstType.STRING.name);

	public static final CType ARRAY_PROTOTYPE = new CType(CConstDataUnit.ARRAY_PROTOTYPE.name);
	public static final CType ARRAY = new CType(CConstType.ARRAY.name);
}
