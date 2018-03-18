package loki.runtime.datatype;

public class LObject extends LObjectPrototype
{
	{
		addParent(LObjectPrototype.instance);
	}

	public LObject(LUnit[] items)
	{
		super(items);
	}
}
