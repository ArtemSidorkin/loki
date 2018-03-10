package loki.runtime.datatype;

public class LMap extends LMapPrototype
{
	{
		addParent(LMapPrototype.instance);
	}

	public LMap(LUnit[] items)
	{
		super(items);
	}
}
