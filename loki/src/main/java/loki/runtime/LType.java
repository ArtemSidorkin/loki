package loki.runtime;

import loki.runtime.util.Compiler;

public class LType
{
	private static class Anonymous
	{
		public static final String NAME = "\\";
	}

	private final String name;
	private final String id;

	@Compiler
	public LType(String name, Class typeClass)
	{
		this.name = name;
		this.id = typeClass.getName();
	}

	@Compiler
	public static LType createAnonymous()
	{
		return new LType(Anonymous.NAME, Anonymous.class); // TODO: class should be unique
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