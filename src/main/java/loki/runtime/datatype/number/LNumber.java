package loki.runtime.datatype.number;

import loki.runtime.constant.LTypes;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.type.LType;

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
	public LType getType()
	{
		return LTypes.NUMBER;
	}

	@Override
	protected ConcurrentLinkedDeque<LUnit> getParents()
	{
		if (parents != null) return parents;

		return _parents;
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

	@Override
	protected void initParentsIfNeeded() {}
}

