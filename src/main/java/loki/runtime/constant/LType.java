package loki.runtime.constant;

public enum LType
{
	TYPE("Type"),
	ANONYMOUS("\\"),
	BOOLEAN("Boolean"),
	NUMBER("Number"),
	STRING("String"),
	ARRAY("Array"),
	MAP("Map");

	public String name;

	LType(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
