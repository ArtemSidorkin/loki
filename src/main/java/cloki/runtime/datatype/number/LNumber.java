package cloki.runtime.datatype.number;

import cloki.runtime.constant.LTypes;
import cloki.runtime.datatype.LType;
import cloki.runtime.datatype.LUndefined;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.utils.Nullable;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LNumber extends LNumberPrototype
{
	private static final ConcurrentLinkedDeque<LUnit> _parents = new ConcurrentLinkedDeque<>();

	static
	{
		_parents.add(LNumberPrototype.instance);
	}

	public LNumber(double value)
	{
		super(value);
	}

	@Override
	public LUnit addParent(LUnit parent)
	{
		if (parents == null) synchronized (this)
		{
			if (parents == null) parents = new ConcurrentLinkedDeque<>(_parents);
		}
		parents.add(parent);
		return this;
	}

	@Nullable
	public <T extends LUnit> T asType(LType type)
	{
		if (getType()._equals(type)) return (T)this;

		for (Iterator<LUnit> parentIterator = getParents().descendingIterator(); parentIterator.hasNext();)
		{
			LUnit parent = parentIterator.next();

			if (parent != null)
			{
				LUnit parentAsType = parent.asType(type);
				if (parentAsType != null) return (T)parentAsType;
			}
		}

		return null;
	}

	public LUnit getSuperMember(String superMemberName)
	{
		for (Iterator<LUnit> parentIterator = getParents().descendingIterator(); parentIterator.hasNext();)
		{
			LUnit parent = parentIterator.next();

			if (parent != null)
			{
				LUnit member = parent.getMember(superMemberName);

				if (member != LUndefined.instance) return member;
			}
		}

		return LUndefined.instance;
	}

	protected void initParentsIfNeeded() {}

	public ConcurrentLinkedDeque<LUnit> getParents()
	{
		if (parents != null) return parents;

		return _parents;
	}

	@Override
	public LType getType()
	{
		return LTypes.NUMBER;
	}
}

