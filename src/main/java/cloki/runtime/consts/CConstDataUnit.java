package cloki.runtime.consts;

public enum CConstDataUnit
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

	CConstDataUnit(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
