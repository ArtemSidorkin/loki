package cloki.runtime.constant;

public enum LFunctionalUnit
{
	INCLUDE("include"),
	IMPORT("import"),
	LOOP("loop"),
	TIME("time"),
	PRINTLN("println");

	public String name;

	LFunctionalUnit(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
