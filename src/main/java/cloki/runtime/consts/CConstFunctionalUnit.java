package cloki.runtime.consts;

public enum CConstFunctionalUnit
{
	INCLUDE("include"),
	IMPORT("import"),
	LOOP("loop"),
	TIME("time"),
	NUMERIC_NEGATION("numericNegation"),
	LOGICAL_NEGATION("logicalNegation"),
	PRINTLN("println");

	public String name;

	CConstFunctionalUnit(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
