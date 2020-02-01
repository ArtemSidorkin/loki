package loki.runtime.datatype.type;

import loki.runtime.datatype.LBoolean;
import loki.runtime.datatype.LString;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.type.member.LGetIdTypeMember;
import loki.runtime.datatype.type.member.LGetNameTypeMember;

import java.util.concurrent.atomic.AtomicLong;

public class LType extends LUnit
{
	public static final long META_TYPE_ID = 0;

	private static final AtomicLong idGenerator = new AtomicLong(0);
	private static volatile LType type;

	private final String name;
	private final long id = idGenerator.incrementAndGet();
	private volatile boolean builtinsInitialized = false;

	public LType(String name)
	{
		super(null);
		this.name = name;
	}

	public static LType createAnonymous()
	{
		return new LType(loki.runtime.constant.LType.ANONYMOUS.name);
	}

	public static String makeFullName(String name, long id)
	{
		return String.format("%s(%s)", name, id);
	}

	public String getFullName()
	{
		return makeFullName(name, id);
	}

	public String getName()
	{
		return name;
	}

	public long getId()
	{
		return id;
	}

	@Override
	public LType getType()
	{
		if (type == null) synchronized(this)
		{
			type = new LType(loki.runtime.constant.LType.TYPE.name);
		}

		return type;
	}

	@Override
	public LUnit getMember(String memberName)
	{
		if (!builtinsInitialized) synchronized(this)
		{
			if (!builtinsInitialized)
			{
				initializeBuiltins();
				builtinsInitialized = true;
			}
		}

		return super.getMember(memberName);
	}

	@Override
	public LNumber _hashCode()
	{
		return new LNumber(Long.hashCode(id));
	}

	@Override
	public LBoolean _equals(LUnit unit)
	{
		return LBoolean.valueOf(this == unit);
	}

	@Override
	public LString _toString()
	{
		return new LString(name);
	}

	private void initializeBuiltins()
	{
		LGetIdTypeMember.instance.init(this);
		LGetNameTypeMember.instance.init(this);
	}
}