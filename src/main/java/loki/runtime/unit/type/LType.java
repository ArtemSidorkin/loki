package loki.runtime.unit.type;

public class LType
{
	private static class Anonymous {}

	private final String name;
	private final String id;

	public LType(String name, Class typeClass)
	{
		this.name = name;
		this.id = typeClass.getName();
	}

	public static LType createAnonymous()
	{
		return new LType(loki.runtime.constant.LType.ANONYMOUS.name, Anonymous.class); // TODO: class should be unique
	}

	public String getFullName()
	{
		return String.format("%s(%s)", name, id);
	}

	public String getName()
	{
		return name;
	}

	public String getId()
	{
		return id;
	}

	@Override
	public String toString()
	{
		return getFullName();
	}
}