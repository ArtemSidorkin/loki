package loki.runtime;

import loki.runtime.compilerapi.type.TypeConstructor;

public class LType
{
	public static final String ANONYMOUS_TYPE_NAME = "\\";

	private final String name;
	private final String id;

	@TypeConstructor
	public LType(String name, Class<?> typeClass)
	{
		this.name = name;
		this.id = typeClass.getName();
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