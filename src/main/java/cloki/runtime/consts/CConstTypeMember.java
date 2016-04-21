package cloki.runtime.consts;

public enum CConstTypeMember
{
	GET_NAME("getName"),
	GET_ID("getId");

	public String name;

	CConstTypeMember(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
