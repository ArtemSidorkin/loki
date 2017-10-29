package cloki.runtime.datatype;


public class LBoolean extends LBooleanPrototype
{
	{
		addParent(LBooleanPrototype.instance);
	}

	public LBoolean(boolean value)
	{
		super(value);
	}
}
