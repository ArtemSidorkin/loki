package loki.runtime.constant;

public enum LDataUnit
{
	VOID("void"),
	NONE("none"),
	TRUE("true"),
	FALSE("false"),
	BOOLEAN_PROTOTYPE("BooleanPrototype"),
	UNIT_PROTOTYPE("UnitPrototype"),
	NUMBER_PROTOTYPE("NumberPrototype"),
	STRING_PROTOTYPE("StringPrototype"),
	ARRAY_PROTOTYPE("ArrayPrototype"),
	MAP_PROTOTYPE("MapPrototype"),
	OBJECT_PROTOTYPE("ObjectPrototype");

	public String name;

	LDataUnit(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
