package cloki.runtime.datatype;

import cloki.runtime.constant.LTypes;

public class LStringPrototype extends LUnit
{
	public static final LStringPrototype instance = new LStringPrototype();

	private final String value;

	protected LStringPrototype(String value)
	{
		super(LTypes.STRING);
		this.value = value;
	}

	private LStringPrototype()
	{
		super(LTypes.STRING_PROTOTYPE);
		value = "";
	}

	public String getValue()
	{
		return value;
	}

	@Override
	public int _hashCode()
	{
		return value.hashCode();
	}

	@Override
	public boolean _equals(LUnit unit)
	{
		LString string = unit.asType(LTypes.STRING);
		return string != null && getValue().equals(string.getValue());
	}

	@Override
	public String _toString()
	{
		return value;
	}
}
