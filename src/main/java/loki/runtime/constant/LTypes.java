package loki.runtime.constant;

public class LTypes
{
	public static final loki.runtime.datatype.LType BOOLEAN_PROTOTYPE = new loki.runtime.datatype.LType(LDataUnit.BOOLEAN_PROTOTYPE.name);
	public static final loki.runtime.datatype.LType BOOLEAN = new loki.runtime.datatype.LType(LType.BOOLEAN.name);

	public static final loki.runtime.datatype.LType NUMBER_PROTOTYPE = new loki.runtime.datatype.LType(LDataUnit.NUMBER_PROTOTYPE.name);
	public static final loki.runtime.datatype.LType NUMBER = new loki.runtime.datatype.LType(LType.NUMBER.name);

	public static final loki.runtime.datatype.LType STRING_PROTOTYPE = new loki.runtime.datatype.LType(LDataUnit.STRING_PROTOTYPE.name);
	public static final loki.runtime.datatype.LType STRING = new loki.runtime.datatype.LType(LType.STRING.name);

	public static final loki.runtime.datatype.LType ARRAY_PROTOTYPE = new loki.runtime.datatype.LType(LDataUnit.ARRAY_PROTOTYPE.name);
	public static final loki.runtime.datatype.LType ARRAY = new loki.runtime.datatype.LType(LType.ARRAY.name);

	public static final loki.runtime.datatype.LType MAP_PROTOTYPE = new loki.runtime.datatype.LType(LDataUnit.MAP_PROTOTYPE.name);
	public static final loki.runtime.datatype.LType MAP = new loki.runtime.datatype.LType(LType.MAP.name);
}
