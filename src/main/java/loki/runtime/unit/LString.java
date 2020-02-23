package loki.runtime.unit;

import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LString extends LUnit
{
	public static final String TYPE_NAME = "String";
	public static final LType TYPE = new LType(TYPE_NAME, LString.class);

	public static final String PROTOTYPE_NAME = "StringPrototype";
	public static final LType PROTO_TYPE = new LType(PROTOTYPE_NAME, LString.class);
	public static final LString PROTOTYPE = new LString();

	private final String value;

	public LString(String value)
	{
		super(TYPE);

		_addParents(PROTOTYPE);

		this.value = value;
	}

	private LString()
	{
		super(PROTO_TYPE);
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
		LString string = unit.asType(TYPE);

		return string != null ? LBoolean.valueOf(value.equals(string.value)) : LBoolean.FALSE;
	}

	@Override
	public LString _toString()
	{
		return new LString(value);
	}
}
