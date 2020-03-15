package loki.runtime.unit.data;

import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LDataUnitDescriptor;
import loki.runtime.util.Compiler;
import loki.runtime.util.Prototype;

public class LString extends LUnit
{
	public static final LDataUnitDescriptor<LString> DESCRIPTOR =
		new LDataUnitDescriptor<>("String", "StringPrototype", LString.class, LString::new);

	private final String value;

	@Compiler
	public LString(String value)
	{
		super(DESCRIPTOR.getType());

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
		LString string = unit.asType(DESCRIPTOR.getType());

		return string != null ? LBoolean.valueOf(value.equals(string.value)) : LBoolean.FALSE.getInstance();
	}

	@Override
	public LString _toString()
	{
		return new LString(value);
	}
}
