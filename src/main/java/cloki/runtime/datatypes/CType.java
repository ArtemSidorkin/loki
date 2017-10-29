package cloki.runtime.datatypes;

import cloki.runtime.builtins.CBuiltins;
import cloki.runtime.consts.CConstType;
import cloki.utils.CIdGenerator;

public class CType extends CUnit
{
	private static volatile CType TYPE;
	private static final CIdGenerator idGenerator = new CIdGenerator();

	public final long id = idGenerator.apply();

	private final String name;
	private volatile boolean builtinsInitialized = false;

	public CType(CType original)
	{
		this(original.getName());
	}

	public CType(String name)
	{
		super((CType) null);
		this.name = name;
	}

	public static CType createAnonymous()
	{
		return new CType(CConstType.ANONYMOUS.name);
	}

	public String getName()
	{
		return name;
	}

	public String getNameWithId()
	{
		return String.format("%s#%s", name, id);
	}

	@Override
	public CType getType()
	{
		if (TYPE == null) synchronized(guard)
		{
			TYPE = new CType(CConstType.TYPE.name);
		}
		return TYPE;
	}

	@Override
	public CUnit getMember(String memberName)
	{
		if (!builtinsInitialized) synchronized(guard)
		{
			if (!builtinsInitialized)
			{
				CBuiltins.initType(this);
				builtinsInitialized = true;
			}
		}
		return super.getMember(memberName);
	}

	@Override
	public boolean _equals(CUnit unit)
	{
		return this == unit;
	}

	@Override
	public boolean equals(Object object)
	{
		return this == object;
	}

	@Override
	public String _toString()
	{
		return name;
	}
}
