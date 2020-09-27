package loki.runtime.unit.data;

import loki.runtime.marker.Prototype;
import loki.runtime.marker.compilerapi.string.StringConstructor;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LPrototypeDescriptor;

public class LString extends LUnit
{
	public static final LPrototypeDescriptor<LString> DESCRIPTOR =
		new LPrototypeDescriptor<>("String", "StringPrototype", LString.class, LString::new);

	private final String value;

	@StringConstructor
	public LString(String value)
	{
		super(DESCRIPTOR.getUnitType());

		_addParents(DESCRIPTOR.getPrototype());

		this.value = value;
	}

	@Prototype
	private LString()
	{
		super(DESCRIPTOR.getPrototypeType());
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
		LString string = unit.asType(DESCRIPTOR.getUnitType());

		return string != null ? LBoolean.valueOf(value.equals(string.value)) : LBoolean.FALSE.getInstance();
	}

	@Override
	public LString _toString()
	{
		return new LString(value);
	}
}
