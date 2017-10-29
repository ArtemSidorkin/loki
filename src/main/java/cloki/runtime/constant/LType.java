package cloki.runtime.constant;

public enum LType
{
	TYPE("Type"),
	ANONYMOUS("\\"),
	BOOLEAN("Boolean"),
	NUMBER("Number"),
	STRING("String"),
	ARRAY("Array");

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
