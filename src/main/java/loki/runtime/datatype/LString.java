package loki.runtime.datatype;

import loki.runtime.constant.LTypes;
import loki.runtime.datatype.number.LNumber;
import loki.runtime.datatype.unit.LUnit;

public class LString extends LUnit
{
	public static final LString instance = new LString();

	private final String value;

	public LString(String value)
	{
		super(LTypes.STRING);
		this.value = value;
		addParent(instance);
	}

	private LString()
	{
		super(LTypes.STRING_PROTOTYPE);
		value = "";
	}

	public String getValue()
	{
		return value;
	}

	@Override
	public LNumber _hashCode()
	{
		return new LNumber(value.hashCode());
	}

	@Override
	public boolean _equals(LUnit unit)
	{
		LString string = unit.asType(LTypes.STRING);
		return string != null && getValue().equals(string.getValue());
	}

	@Override
	public LString _toString()
	{
		return new LString(value);
	}
}
