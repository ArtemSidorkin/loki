package cloki.runtime.datatype;

public class LNumber extends LNumberPrototype
{
	{
		addParent(LNumberPrototype.instance);
	}

	public LNumber(double value)
	{
		super(value);
	}
}

