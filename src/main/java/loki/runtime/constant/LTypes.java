package loki.runtime.constant;

import loki.runtime.unit.LArray;
import loki.runtime.unit.LMap;
import loki.runtime.unit.LObject;
import loki.runtime.unit.LString;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.LNumber;

public class LTypes
{
	public static final loki.runtime.unit.type.LType BOOLEAN_PROTOTYPE =
		new loki.runtime.unit.type.LType(LBoolean.PROTOTYPE_NAME);

	public static final loki.runtime.unit.type.LType BOOLEAN = new loki.runtime.unit.type.LType(LType.BOOLEAN.name);



	public static final loki.runtime.unit.type.LType NUMBER_PROTOTYPE =
		new loki.runtime.unit.type.LType(LNumber.PROTOTYPE_NAME);

	public static final loki.runtime.unit.type.LType NUMBER = new loki.runtime.unit.type.LType(LType.NUMBER.name);



	public static final loki.runtime.unit.type.LType STRING_PROTOTYPE =
		new loki.runtime.unit.type.LType(LString.PROTOTYPE_NAME);

	public static final loki.runtime.unit.type.LType STRING = new loki.runtime.unit.type.LType(LType.STRING.name);



	public static final loki.runtime.unit.type.LType ARRAY_PROTOTYPE =
		new loki.runtime.unit.type.LType(LArray.PROTOTYPE_NAME);

	public static final loki.runtime.unit.type.LType ARRAY = new loki.runtime.unit.type.LType(LType.ARRAY.name);



	public static final loki.runtime.unit.type.LType MAP_PROTOTYPE =
		new loki.runtime.unit.type.LType(LMap.PROTOTYPE_NAME);

	public static final loki.runtime.unit.type.LType MAP = new loki.runtime.unit.type.LType(LType.MAP.name);



	public static final loki.runtime.unit.type.LType OBJECT_PROTOTYPE =
		new loki.runtime.unit.type.LType(LObject.PROTOTYPE_NAME);

	public static final loki.runtime.unit.type.LType OBJECT = new loki.runtime.unit.type.LType(LType.OBJECT.name);
}
