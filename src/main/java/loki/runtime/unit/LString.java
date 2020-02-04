package loki.runtime.unit;

import loki.runtime.constant.LTypes;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;

public class LString extends LUnit
{
	public static final LString instance = new LString();

	private final String value;

	public LString(String value)
	{
		super(LTypes.STRING);
		this.value = value;
		_addParents(instance);
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
	public LBoolean _equals(LUnit unit)
	{
		LString string = new LString(unit.toString());

		return LBoolean.valueOf(value.equals(string.value));
	}

	@Override
	public LString _toString()
	{
		return new LString(value);
	}
}
