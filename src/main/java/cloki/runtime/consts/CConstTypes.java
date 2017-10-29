package cloki.runtime.consts;

import cloki.runtime.datatype.LType;

public class CConstTypes
{
	public static final LType BOOLEAN_PROTOTYPE = new LType(LConstDataUnit.BOOLEAN_PROTOTYPE.name);
	public static final LType BOOLEAN = new LType(CConstType.BOOLEAN.name);

	public static final LType NUMBER_PROTOTYPE = new LType(LConstDataUnit.NUMBER_PROTOTYPE.name);
	public static final LType NUMBER = new LType(CConstType.NUMBER.name);

	public static final LType STRING_PROTOTYPE = new LType(LConstDataUnit.STRING_PROTOTYPE.name);
	public static final LType STRING = new LType(CConstType.STRING.name);

	public static final LType ARRAY_PROTOTYPE = new LType(LConstDataUnit.ARRAY_PROTOTYPE.name);
	public static final LType ARRAY = new LType(CConstType.ARRAY.name);
}
