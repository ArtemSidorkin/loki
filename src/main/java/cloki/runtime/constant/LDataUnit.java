package cloki.runtime.constant;

public enum LDataUnit
{
	UNDEFINED("undefined"),
	VOID("void"),
	NONE("none"),
	TRUE("true"),
	FALSE("false"),
	BOOLEAN_PROTOTYPE("BooleanPrototype"),
	UNIT_PROTOTYPE("UnitPrototype"),
	NUMBER_PROTOTYPE("NumberPrototype"),
	STRING_PROTOTYPE("StringPrototype"),
	ARRAY_PROTOTYPE("ArrayPrototype");

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
