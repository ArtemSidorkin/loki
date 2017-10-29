package cloki.runtime.datatypes;


public class CBoolean extends CBooleanPrototype
{
	{
		addParent(CBooleanPrototype.instance);
	}

	public CBoolean(boolean value)
	{
		super(value);
	}
}
