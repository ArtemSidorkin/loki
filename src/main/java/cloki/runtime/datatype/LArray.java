package cloki.runtime.datatype;

public class LArray extends LArrayPrototype
{
	{
		addParent(LArrayPrototype.instance);
	}

	public LArray(LUnit[] items)
	{
		super(items);
	}
}
