package cloki.runtime.datatypes;

public class CString extends CStringPrototype
{
	{
		addParent(CStringPrototype.instance);
	}

	public CString(String value)
	{
		super(value);
	}
}
