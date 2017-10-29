package cloki.runtime.datatypes;

public class CNumber extends CNumberPrototype
{
	{
		addParent(CNumberPrototype.instance);
	}

	public CNumber(double value)
	{
		super(value);
	}
}

