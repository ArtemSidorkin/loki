package cloki.runtime.consts;

public enum CConstType
{
	TYPE("Type"),
	ANONYMOUS("\\"),
	BOOLEAN("Boolean"),
	NUMBER("Number"),
	STRING("String"),
	ARRAY("Array");

	public String name;

	CConstType(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
