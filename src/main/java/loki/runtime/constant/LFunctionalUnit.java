package loki.runtime.constant;

public enum LFunctionalUnit
{
	ASSERT("assert"),
	USE("use"),
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
