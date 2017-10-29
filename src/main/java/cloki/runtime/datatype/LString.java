package cloki.runtime.datatype;

public class LString extends LStringPrototype
{
	{
		addParent(LStringPrototype.instance);
	}

	public LString(String value)
	{
		super(value);
	}
}
