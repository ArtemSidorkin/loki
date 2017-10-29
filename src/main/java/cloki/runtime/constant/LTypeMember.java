package cloki.runtime.constant;

public enum LTypeMember
{
	GET_NAME("getName"),
	GET_ID("getId");

	public String name;

	LTypeMember(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
