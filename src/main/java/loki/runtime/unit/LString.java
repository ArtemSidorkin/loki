package loki.runtime.unit;

import loki.runtime.constant.LTypes;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;

public class LString extends LUnit
{
	public static final LString PROTOTYPE = new LString();

	private final String value;

	public LString(String value)
	{
		super(LTypes.STRING);

		_addParents(PROTOTYPE);

		this.value = value;
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
		LString string = unit.asType(LTypes.STRING);

		return string != null ? LBoolean.valueOf(value.equals(string.value)) : LBoolean.FALSE;
	}

	@Override
	public LString _toString()
	{
		return new LString(value);
	}
}
