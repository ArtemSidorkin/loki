package loki.runtime.datatype.type;

import loki.runtime.LSettings;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.type.member.LGetIdTypeMember;
import loki.runtime.datatype.type.member.LGetNameTypeMember;
import loki.runtime.datatype.type.member.internal.*;
import loki.util.IdGenerator;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LType extends LUnit
{
	private static final IdGenerator idGenerator = new IdGenerator();

	private static final ConcurrentMap<String, LTypeInternalMember> internalMembers =
		new ConcurrentHashMap<String, LTypeInternalMember>(
			LSettings.INTERNAL_MEMBERS_INITIAL_CAPACITY,
			LSettings.INTERNAL_MEMBERS_LOAD_FACTOR,
			LSettings.INTERNAL_MEMBERS_CONCURRENCY_LEVEL
		)
		{{
			LHashCodeTypeInternalMember.instance.initialize(this);
			LToStringTypeInternalMember.instance.initialize(this);

			LGetIdTypeInternalMember.instance.initialize(this);
			LGetNameTypeInternalMember.instance.initialize(this);
		}};

	private static volatile LType type;

	public final String name;
	public final long id = idGenerator.apply();

	private volatile boolean builtinsInitialized = false;

	public LType(LType original)
	{
		this(original.name);
	}

	public LType(String name)
	{
		super(null);
		this.name = name;
	}

	public static LType createAnonymous()
	{
		return new LType(loki.runtime.constant.LType.ANONYMOUS.name);
	}

	public String getNameWithId()
	{
		return String.format("%s#%s", name, id);
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
	public LUnit setMember(String memberName, LUnit member)
	{
		internalMembers.remove(memberName);
		return super.setMember(memberName, member);
	}

	@Override
	public LUnit callMember(String memberName, LUnit[] parameters)
	{
		LTypeInternalMember internalMember = internalMembers.get(memberName);

		if (internalMember != null) return internalMember.apply(name, id, parameters);

		return super.callMember(memberName, parameters);
	}

	@Override
	public int _hashCode()
	{
		return Long.hashCode(id);
	}

	@Override
	public boolean _equals(LUnit unit)
	{
		return this == unit;
	}

	@Override
	public String _toString()
	{
		return name;
	}

	private void initializeBuiltins()
	{
		LGetIdTypeMember.instance.init(this);
		LGetNameTypeMember.instance.init(this);
	}
}